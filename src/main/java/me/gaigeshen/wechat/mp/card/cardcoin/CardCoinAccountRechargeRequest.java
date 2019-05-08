package me.gaigeshen.wechat.mp.card.cardcoin;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;

/**
 * 充值券点
 *
 * @author gaigeshen
 */
@Getter
public class CardCoinAccountRechargeRequest implements Request<CardCoinAccountRechargeResponse> {
  @JSONField(name = "coin_count")
  private int coinCount;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/pay/recharge?access_token=ACCESS_TOKEN";
  }
}
