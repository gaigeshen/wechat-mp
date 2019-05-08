package me.gaigeshen.wechat.mp.card.cardcoin;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 对优惠券批价
 *
 * @author gaigeshen
 */
@Builder
public class CardCoinPriceRequest implements Request<CardCoinPriceResponse> {
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "quantity") private int quantity;

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/pay/getpayprice?access_token=ACCESS_TOKEN";
  }
}
