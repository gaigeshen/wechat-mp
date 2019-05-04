package me.gaigeshen.wechat.mp.oauth2;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import org.apache.commons.lang3.Validate;

/**
 * 刷新网页授权访问令牌
 *
 * @author gaigeshen
 */
public class OAuth2AccessTokenRefreshRequest implements Request<OAuth2AccessTokenRefreshResponse> {
  private final String refreshToken;
  public OAuth2AccessTokenRefreshRequest(String refreshToken) {
    Validate.notBlank(refreshToken, "refreshToken is required");
    this.refreshToken = refreshToken;
  }

  @Override
  public Class<OAuth2AccessTokenRefreshResponse> responseType() {
    return OAuth2AccessTokenRefreshResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=" + refreshToken;
  }
}
