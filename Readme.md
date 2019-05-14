## 微信公众号开发工具
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![Build Status](https://travis-ci.org/gaigeshen/wechat-mp.svg?branch=develop)](https://travis-ci.org/gaigeshen/wechat-mp)
[![Maven Central](https://img.shields.io/maven-central/v/me.gaigeshen.wechat/wechat-mp.svg)](http://mvnrepository.com/artifact/me.gaigeshen.wechat/wechat-mp)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/me.gaigeshen.wechat/wechat-mp.svg)](https://oss.sonatype.org/content/repositories/snapshots/me/gaigeshen/wechat/wechat-mp)
[![GitHub last commit](https://img.shields.io/github/last-commit/gaigeshen/wechat-mp.svg)](https://github.com/gaigeshen/wechat-mp/commits)

- 消息的处理，此处演示常用的配置案例
> 以下配置完毕之后，在微信公众平台启用服务器配置，并且将服务器地址配置为指向`/messages`  
```
// 消息处理器链，会获取所有的消息处理器
// 请根据需要合理选择消息处理器的抽象实现，具体查看源代码
@Bean
public MessageProcessorChain messageProcessorChain(ApplicationContext ctx) {
  return new DefaultMessageProcessorChain(new ArrayList<>(ctx.getBeansOfType(MessageProcessor.class).values()));
}

// 读取微信的全局配置，配置的值要与微信公众平台上的服务器配置保持一致
@Bean
public Config wechatConfig() {
  String appid = ...; 
  String secret = ...;
  String token = ...;
  String encodingAesKey = ...; // 如果配置了该值的话，将会对消息进行加解密操作
  Assert.state(StringUtils.isNotBlank(appid), "appid is required");
  Assert.state(StringUtils.isNotBlank(secret), "secret is required");
  Assert.state(StringUtils.isNotBlank(token), "token is required");
  return Config.builder().appid(appid).secret(secret).token(token).encodingAesKey(encodingAesKey).build();
}
```


- 请求接口使用方式
> 请注意，请求体数据和响应体数据都假定为`json`格式
```
// 卡券签名相关，如果需要开发卡券业务的话
@Bean
public CardSignatureCalculator cardSignatureCalculator(RequestExecutor executor) {
  return new CardSignatureCalculator(executor);
}

// 网页开发相关，如果需要开发网页授权之类的业务的话
@Bean
public JsApiSignatureCalculator jsApiSignatureCalculator(RequestExecutor executor) {
  return new JsApiSignatureCalculator(executor);
}

// 此对象将用于主动请求接口
@Bean(destroyMethod = "close")
public RequestExecutor wechatRequestExecutor(Config config) {
  return new RequestExecutor(new HttpClientExecutor(2000, 2000, 3000), config);
}
```
```
// 构造请求对象
XXXRequest req = ...

// 执行请求
XXXResponse resp = executor.execute(req);

// 打印请求结果是否成功，以及其他数据
System.out.println("error code: " + resp.getErrorCode());
System.out.println("error message: " + resp.getErrorMessage());
```

- 如何知道使用哪个请求对象
```
// 将微信文档里面的请求链接，在项目里面全局搜索即可
// 搜索的时候，建议只搜索不带参数的形式的链接，因为很可能参数有占位符名称不一致
```

- 假如微信的某个接口没有找到对应的请求类怎么办
```
// 自定义实现响应接口
public class YourResponse extends AbstractResponse {
  // 这里是定义响应的数据字段
}
// 自定义实现请求接口
public class YourRequest implements Request<YourResponse> {
  // 这里是定义请求的数据字段

  // 此处返回请求方式，此方法有默认实现
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    // 此处写请求接口的地址
    return "https://api.weixin.qq.com/...";
  }
}
```

- 如何定义`multipart/form-data`形式的请求
```
public class YourUploadRequest implements Request<YourUploadResponse> {
  // 普通字段
  private String type;
  // 此处的字段类型必须上传项目，字段名称对应接口文档的说明即可
  private UploadItem media;
  @Override
  public String requestUri() {
    // 此处写请求接口的地址
    return "https://api.weixin.qq.com/...";
  }
}
```

- 假如我需要定义请求体是单个文件的请求
```
// 请求类直接实现上传项目，此种类型的请求对象内的所有字段将被忽略
public class YourUploadRequest implements Request<YourUploadResponse>, UploadItem {
  private final UploadItem item;
  private YourUploadRequest(UploadItem item) {
    this.item = item;
  }
  public static YourUploadRequest create(UploadItem item) {
    Validate.notNull(item, "Upload item is required");
    return new YYYUploadRequest(item);
  }
  @Override
  public String requestUri() {
    // 此处写请求接口的地址
    return "https://api.weixin.qq.com/...";
  }
  @Override
  public String getFilename() {
    return item.getFilename();
  }
  @Override
  public byte[] getContent() {
    return item.getContent();
  }
}
```

- 我在自定义请求类的时候，我不想定义对应的响应类
```
// 这样的话，响应对象里只有响应码和响应消息数据
public class YourRequest implements Request<EmptyDataResponse> {
  @Override
  public String requestUri() {
    // 此处写请求接口的地址
    return "https://api.weixin.qq.com/...";
  }
}
```

- 我在自定义请求类的时候，文档对响应结果说的不是很明确，我必须先请求一次才能确定怎么定义响应类
```
// 这样的话，不会尝试自动转换为响应对象，而是直接将接口的原始响应内容打印出来
executor.execute(req, new StringResponseBodyPrintHandler());
```

- 对于下载文件类的请求，如何定义响应类
```
// 实现请求结果处理器
public class YourResponseBodyHandler implements ResponseBodyHandler {
  @Override
  public void handle(String contentType, byte[] content) {
    // 第一个参数告诉你，响应的数据类型
    // 第二个参数是传递给你原始数据
    // 接下来你可以处理数据了
  }
}

// 执行请求的时候，将刚才定义的请求结果处理器传入即可
executor.execute(req, new YourResponseBodyHandler());

// 系统现在已经定义了常用的下载文件类的请求结果处理器，请查看具体的源代码了解
```