package me.gaigeshen.wechat.mp.user;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 取消黑名单
 *
 * @author gaigeshen
 */
public class BlackListCancelRequest implements Request<BlackListCancelResponse> {
  @JSONField(name = "openid_list")
  private String[] users;
  @Override
  public Class<BlackListCancelResponse> responseType() {
    return BlackListCancelResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=ACCESS_TOKEN";
  }
}
