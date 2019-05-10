package me.gaigeshen.wechat.mp;

import lombok.extern.slf4j.Slf4j;
import me.gaigeshen.wechat.mp.accesstoken.AccessTokenRequest;
import me.gaigeshen.wechat.mp.accesstoken.AccessTokenResponse;
import me.gaigeshen.wechat.mp.commons.HttpClientExecutor;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import me.gaigeshen.wechat.mp.commons.JsonUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.ContentResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.stream.Stream;

/**
 * 请求执行器
 *
 * @author gaigeshen
 */
@Slf4j
public class RequestExecutor implements Closeable {

  private static final ContentResponseHandler RESPONSE_HANDLER = new ContentResponseHandler();

  private final HttpClientExecutor executor;
  private final Config config;

  private String accessToken;
  private long accessTokenExpiresAtTimestamp;

  /**
   * 创建请求执行器
   */
  public RequestExecutor(HttpClientExecutor executor, Config config) {
    this.executor = executor;
    this.config = config;
    initializeAccessToken();
  }

  @Override
  public void close() throws IOException {
    executor.close();
  }

  /**
   * 初始化访问令牌
   */
  private void initializeAccessToken() {
    log.debug("Initialize access token ...");
    refreshAccessToken(true);
  }

  /**
   * 刷新访问令牌
   *
   * @param force 是否强制刷新，在非强制刷新情况下会判断是否过期，如未过期则不会刷新
   */
  private synchronized void refreshAccessToken(boolean force) {
    long currentTimestamp = System.currentTimeMillis();
    if (!force && currentTimestamp < accessTokenExpiresAtTimestamp) {
      return;
    }
    AccessTokenResponse resp = execute(new AccessTokenRequest());
    if (resp.isSucceeded()) {
      accessToken = resp.getAccessToken();
      // 过期时间往前推移五秒钟，考虑请求访问令牌的时间
      accessTokenExpiresAtTimestamp = currentTimestamp + (resp.getExpiresIn() * 1000 - 5000);
      log.debug("Access token refresh succeeded");
    } else {
      log.debug("Access token refresh failed: " + resp.getErrorMessage());
      throw new IllegalStateException("Could not refresh access token, because " + resp.getErrorMessage());
    }
  }

  /**
   * 获取当前有效的访问令牌
   *
   * @return 有效的访问令牌，如果过期会进行刷新操作
   */
  private String currentAccessToken() {
    long currentTimestamp = System.currentTimeMillis();
    if (currentTimestamp >= accessTokenExpiresAtTimestamp) {
      log.debug("Try to refresh the access token");
      refreshAccessToken(false);
    }
    return accessToken;
  }

  /**
   * 执行请求，请求之后，假设响应体内容为字符串类型，然后将其转化为指定的类型的对象
   *
   * @param request 请求对象
   * @param <R> 响应类型
   * @return 响应
   *
   * @see #execute(Request, ResponseBodyHandler)
   */
  public <R extends Response> R execute(Request<R> request) {
    HttpUriRequest httpReq = buildRequest(request);
    String result = executor.execute(httpReq, RESPONSE_HANDLER).asString(Charset.forName("utf-8"));
    logRequestAndResponse(httpReq, result);
    return JsonUtils.fromJson(result, request.responseType());
  }

  /**
   * 执行请求，如果响应体内容是字符串类型，请不要调用此方法
   *
   * @param request 请求对象
   * @param handler 请求结果处理器，由用户决定怎么处理结果，常用于下载类的请求
   *
   * @see #execute(Request)
   */
  public void execute(Request<?> request, ResponseBodyHandler handler) {
    Validate.notNull(handler, "handler is required");
    HttpUriRequest httpReq = buildRequest(request);
    Content content = executor.execute(httpReq, RESPONSE_HANDLER);
    logRequestAndResponse(httpReq, null);
    handler.handle(content.getType().toString(), content.asBytes());
  }

  private HttpUriRequest buildRequest(Request<?> request) {
    HttpMethod httpMethod = request.httpMethod();
    Validate.notNull(httpMethod, "Http method of this request %s is null", request);
    String requestUri = request.requestUri();
    Validate.notBlank(requestUri, "Request uri of this request %s is blank", request);
    Class<?> responseType = request.responseType();
    Validate.notNull(responseType, "Response type of this request %s is null", request);

    HttpUriRequest httpReq = httpMethod.equals(HttpMethod.GET)
            ? new HttpGet(replacePlaceholderForQueryString(requestUri))
            : new HttpPost(replacePlaceholderForQueryString(requestUri));
    if (httpMethod.equals(HttpMethod.POST)) {
      if (request instanceof UploadItem) {
        // 如果该请求直接是上传文件，则会忽略掉所有的普通字段，只关注上传文件
        ((HttpPost) httpReq).setEntity(new ByteArrayEntity(((UploadItem) request).getContent()));
        return httpReq;
      }
      Field[] fields = FieldUtils.getAllFields(request.getClass());
      boolean uploadable = Stream.of(fields).anyMatch(f -> ClassUtils.isAssignable(f.getType(), UploadItem.class));
      if (!uploadable) {
        String entity = JsonUtils.toJson(request);
        ((HttpPost) httpReq).setEntity(new StringEntity(entity, "utf-8"));
      } else { // 该请求的某个字段是需要上传文件的
        processUploadable(request, fields, (HttpPost) httpReq);
      }
    }
    return httpReq;
  }

  private void processUploadable(Request<?> request, Field[] fields, HttpPost httpReq) {
    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
    try {
      for (Field field : fields) {
        field.setAccessible(true);
        if (ClassUtils.isAssignable(field.getType(), UploadItem.class)) {
          UploadItem item = (UploadItem) field.get(request);
          builder.addBinaryBody(field.getName(), item.getContent(), ContentType.DEFAULT_BINARY, item.getFilename());
        } else {
          builder.addTextBody(field.getName(), String.valueOf(field.get(request)), ContentType.DEFAULT_TEXT.withCharset("utf-8"));
        }
      }
    } catch (IllegalAccessException e) {
      throw new IllegalStateException("Could not build multipart entity from request: " + request, e);
    }
    httpReq.setEntity(builder.build());
  }

  /**
   * 打印请求和响应日志，响应内容必须是字符串类型，如果是下载类的请求，则响应内容参数传递空对象。
   * 请求发送的数据如果是字符串类型才会打印出来。
   *
   * @param httpReq 请求对象
   * @param result 响应字符串对象，可不传递
   */
  private void logRequestAndResponse(HttpUriRequest httpReq, String result) {
    StringBuilder builder = new StringBuilder();
    builder.append(httpReq);
    if (httpReq instanceof HttpPost) {
      HttpEntity entity = ((HttpPost) httpReq).getEntity();
      if (entity instanceof StringEntity) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buff = new byte[2048];
        int len;
        try (InputStream in = ((StringEntity) entity).getContent()) {
          while ((len = in.read(buff)) > 0) {
            out.write(buff, 0, len);
          }
        } catch (IOException e) {
          throw new IllegalStateException(e);
        }
        builder.append("\n<< ENTITY >> ").append(out);
      }
    }
    if (StringUtils.isNotBlank(result)) {
      builder.append("\n<< RESULT >> ").append(result);
    } else {
      builder.append("\n<< RESULT >> No printable result");
    }
    log.debug(builder.toString());
  }

  /**
   * 替换请求链接的占位符
   *
   * @param uri 请求链接
   * @return 替换占位符后的请求链接
   */
  private String replacePlaceholderForQueryString(String uri) {
    if (StringUtils.contains(uri, "ACCESS_TOKEN")) {
      // 如果请求链接里需要访问令牌参数
      // 则带上当前有效的访问令牌
      uri = uri.replaceAll("ACCESS_TOKEN", currentAccessToken());
    }
    return uri.replaceAll("APPID", config.getAppid()).replaceAll("SECRET", config.getSecret());
  }
}
