package me.gaigeshen.wechat.mp;

import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 服务器地址
 *
 * @author gaigeshen
 */
public class ServerAddressRequest implements Request<ServerAddressResponse> {
  @Override
  public Class<ServerAddressResponse> responseType() {
    return ServerAddressResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
  }
}
