package me.gaigeshen.wechat.mp.shakearound.redpack;

import lombok.Builder;
import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 设置红包活动抽奖开关
 *
 * @author gaigeshen
 */
@Builder
public class RedpackActivitySwitchRequest implements Request<EmptyDataResponse> {
  private String lotteryId;
  private int onoff;

  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/lottery/setlotteryswitch?access_token=ACCESSTOKEN&lottery_id="
            + lotteryId + "&onoff=" + onoff;
  }
}
