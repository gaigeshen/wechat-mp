package me.gaigeshen.wechat.mp.user;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 添加黑名单
 *
 * @author gaigeshen
 */
public class BlackListAddRequest implements Request<BlackListAddResponse> {
  @JSONField(name = "openid_list")
  private String[] users;
  @Override
  public Class<BlackListAddResponse> responseType() {
    return BlackListAddResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=ACCESS_TOKEN";
  }
}
