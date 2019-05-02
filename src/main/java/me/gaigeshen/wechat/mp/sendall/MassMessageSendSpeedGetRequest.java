package me.gaigeshen.wechat.mp.sendall;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取群发消息的速度
 *
 * @author gaigeshen
 */
public class MassMessageSendSpeedGetRequest implements Request<MassMessageSendSpeedGetResponse> {
  @Override
  public Class<MassMessageSendSpeedGetResponse> responseType() {
    return MassMessageSendSpeedGetResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/message/mass/speed/get?access_token=ACCESS_TOKEN";
  }
}
