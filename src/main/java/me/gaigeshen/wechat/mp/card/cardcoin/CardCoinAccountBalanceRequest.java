package me.gaigeshen.wechat.mp.card.cardcoin;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 查询券点余额
 *
 * @author gaigeshen
 */
public class CardCoinAccountBalanceRequest implements Request<CardCoinAccountBalanceResponse> {
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/pay/getcoinsinfo?access_token=ACCESS_TOKEN";
  }
}
