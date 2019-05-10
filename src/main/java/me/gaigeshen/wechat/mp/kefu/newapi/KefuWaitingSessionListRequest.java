package me.gaigeshen.wechat.mp.kefu.newapi;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取未接入会话列表
 *
 * @author gaigeshen
 */
public class KefuWaitingSessionListRequest implements Request<KefuWaitingSessionListResponse> {
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/customservice/kfsession/getwaitcase?access_token=ACCESS_TOKEN";
  }
}
