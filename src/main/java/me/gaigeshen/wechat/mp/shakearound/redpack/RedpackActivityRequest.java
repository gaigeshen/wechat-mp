package me.gaigeshen.wechat.mp.shakearound.redpack;

import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 查询红包活动
 *
 * @author gaigeshen
 */
@Builder
public class RedpackActivityRequest implements Request<RedpackActivityResponse> {

  private String lotteryId;

  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/lottery/querylottery?access_token=ACCESSTOKEN&lottery_id=" + lotteryId;
  }
}
