package me.gaigeshen.wechat.mp.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取用户的标签列表
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class UserTagGetRequest implements Request<UserTagGetResponse> {
  @JSONField(name = "openid")
  private String user;
  @Override
  public Class<UserTagGetResponse> responseType() {
    return UserTagGetResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN";
  }
}
