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
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.ContentResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.Closeable;
import java.io.IOException;
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
    this.initializeAccessToken();
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
   * 执行请求
   *
   * @param request 请求对象
   * @param <R> 响应类型
   * @return 响应
   */
  public <R extends Response> R execute(Request<R> request) {
    HttpUriRequest httpReq = buildRequest(request);
    String result = executor.execute(httpReq, RESPONSE_HANDLER).asString(Charset.forName("utf-8"));
    return JsonUtils.fromJson(result, request.responseType());
  }

  /**
   * 执行请求
   *
   * @param request 请求对象
   * @param handler 请求结果处理器，由用户决定怎么处理结果，常用于下载类的请求
   */
  public void execute(Request<?> request, ResponseBodyHandler handler) {
    Validate.notNull(handler, "handler is required");
    HttpUriRequest httpReq = buildRequest(request);
    Content content = executor.execute(httpReq, RESPONSE_HANDLER);
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
      Field[] fields = FieldUtils.getAllFields(request.getClass());
      boolean uploadable = Stream.of(fields).anyMatch(f -> ClassUtils.isAssignable(f.getType(), UploadItem.class));
      if (!uploadable) {
        ((HttpPost) httpReq).setEntity(new StringEntity(JsonUtils.toJson(request), "utf-8"));
      } else {
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
