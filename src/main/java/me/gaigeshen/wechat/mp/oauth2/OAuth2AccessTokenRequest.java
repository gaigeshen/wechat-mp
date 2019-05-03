package me.gaigeshen.wechat.mp.oauth2;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import org.apache.commons.lang3.Validate;

/**
 * 获取网页授权访问令牌
 *
 * @author gaigeshen
 */
public class OAuth2AccessTokenRequest implements Request<OAuth2AccessTokenResponse> {
  private final String code;

  /**
   * 创建获取网页授权访问令牌的请求
   *
   * @param code 通过网页授权得到的授权码
   */
  public OAuth2AccessTokenRequest(String code) {
    Validate.notBlank(code, "code is required");
    this.code = code;
  }
  @Override
  public Class<OAuth2AccessTokenResponse> responseType() {
    return OAuth2AccessTokenResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code="
            + code + "&grant_type=authorization_code";
  }
}
