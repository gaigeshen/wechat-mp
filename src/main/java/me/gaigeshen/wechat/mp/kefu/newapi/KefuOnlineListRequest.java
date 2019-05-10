package me.gaigeshen.wechat.mp.kefu.newapi;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取在线客服列表
 *
 * @author gaigeshen
 */
public class KefuOnlineListRequest implements Request<KefuOnlineListResponse> {
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=ACCESS_TOKEN";
  }
}
