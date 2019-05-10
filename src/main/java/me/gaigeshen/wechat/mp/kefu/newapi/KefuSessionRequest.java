package me.gaigeshen.wechat.mp.kefu.newapi;

import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取客服会话状态
 *
 * @author gaigeshen
 */
@Builder
public class KefuSessionRequest implements Request<KefuSessionResponse> {
  private String openid;
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/customservice/kfsession/getsession?access_token=ACCESS_TOKEN&openid=" + openid;
  }
}
