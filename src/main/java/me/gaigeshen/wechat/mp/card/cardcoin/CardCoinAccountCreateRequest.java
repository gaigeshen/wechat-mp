package me.gaigeshen.wechat.mp.card.cardcoin;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 开通券点账户
 *
 * @author gaigeshen
 */
public class CardCoinAccountCreateRequest implements Request<CardCoinAccountCreateResponse> {
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/pay/activate?access_token=ACCESS_TOKEN";
  }
}
