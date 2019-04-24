package me.gaigeshen.wechat.mp.accesstoken;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 访问令牌请求
 *
 * @author gaigeshen
 */
public class AccessTokenRequest implements Request<AccessTokenResponse> {
  @Override
  public Class<AccessTokenResponse> responseType() {
    return AccessTokenResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";
  }
}
