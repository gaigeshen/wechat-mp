package me.gaigeshen.wechat.mp.card.cardcoin;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 对优惠券批价结果
 *
 * @author gaigeshen
 */
@Getter
public class CardCoinPriceResponse extends AbstractResponse {
  @JSONField(name = "order_id") private String orderId;
  @JSONField(name = "price") private Double price;
  @JSONField(name = "free_coin") private Double freeCoin;
  @JSONField(name = "pay_coin") private Double payCoin;
}
