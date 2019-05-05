package me.gaigeshen.wechat.mp.user;

import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取用户信息
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class UserInfoGetRequest implements Request<UserInfoGetResponse> {
  private String openid;

  @Override
  public Class<UserInfoGetResponse> responseType() {
    return UserInfoGetResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&lang=zh_CN&openid=" + openid;
  }
}
