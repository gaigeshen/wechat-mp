package me.gaigeshen.wechat.mp.user;

import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取用户列表
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class UserListRequest implements Request<UserListResponse> {
  private String nextOpenid;
  @Override
  public Class<UserListResponse> responseType() {
    return UserListResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=" + nextOpenid;
  }
}
