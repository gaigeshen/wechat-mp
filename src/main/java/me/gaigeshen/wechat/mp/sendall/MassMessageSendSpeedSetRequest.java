package me.gaigeshen.wechat.mp.sendall;

import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取群发消息的速度级别
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class MassMessageSendSpeedSetRequest implements Request<MassMessageSendSpeedSetResponse> {
  /**
   * <pre>
   * 0 - 80w/min
   * 1 - 60w/min
   * 2 - 45w/min
   * 3 - 30w/min
   * 4 - 10w/min
   * </pre>
   */
  private int speed;
  @Override
  public Class<MassMessageSendSpeedSetResponse> responseType() {
    return MassMessageSendSpeedSetResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/message/mass/speed/set?access_token=ACCESS_TOKEN";
  }
}
