package me.gaigeshen.wechat.mp.oauth2;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import org.apache.commons.lang3.Validate;

/**
 * 校验网页授权访问令牌是否有效
 *
 * @author gaigeshen
 */
public class OAuth2CheckAccessTokenRequest implements Request<OAuth2CheckAccessTokenResponse> {
  private final String accessToken;
  private final String openid;

  public OAuth2CheckAccessTokenRequest(String accessToken, String openid) {
    Validate.notBlank(accessToken, "accessToken is required");
    Validate.notBlank(openid, "openid is required");
    this.accessToken = accessToken;
    this.openid = openid;
  }

  @Override
  public Class<OAuth2CheckAccessTokenResponse> responseType() {
    return OAuth2CheckAccessTokenResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/sns/auth?access_token=" + accessToken + "&openid=" + openid;
  }
}
