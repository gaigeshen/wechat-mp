package me.gaigeshen.wechat.mp.oauth2;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import org.apache.commons.lang3.Validate;

/**
 * 网页授权获取用户信息
 *
 * @author gaigeshen
 */
public class OAuth2UserInfoRequest implements Request<OAuth2UserInfoResponse> {
  private final String accessToken;
  private final String openid;

  public OAuth2UserInfoRequest(String accessToken, String openid) {
    Validate.notBlank(accessToken, "accessToken is required");
    Validate.notBlank(openid, "openid is required");
    this.accessToken = accessToken;
    this.openid = openid;
  }

  @Override
  public Class<OAuth2UserInfoResponse> responseType() {
    return OAuth2UserInfoResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openid + "&lang=zh_CN";
  }
}
