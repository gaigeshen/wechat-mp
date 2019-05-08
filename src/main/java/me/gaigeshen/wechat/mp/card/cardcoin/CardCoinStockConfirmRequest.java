package me.gaigeshen.wechat.mp.card.cardcoin;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;

/**
 * 确认兑换库存
 *
 * @author gaigeshen
 */
public class CardCoinStockConfirmRequest implements Request<CardCoinStockConfirmResponse> {
  @JSONField(name = "order_id") private String orderId;
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "quantity") private int quantity;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/pay/confirm?access_token=ACCESS_TOKEN";
  }
}
