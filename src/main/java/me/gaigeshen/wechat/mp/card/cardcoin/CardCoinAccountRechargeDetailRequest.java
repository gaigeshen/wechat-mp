package me.gaigeshen.wechat.mp.card.cardcoin;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 查询充值订单的状态
 *
 * @author gaigeshen
 */
@Builder
public class CardCoinAccountRechargeDetailRequest implements Request<CardCoinAccountRechargeDetailResponse> {
  @JSONField(name = "order_id")
  private String orderId;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/pay/getorder?access_token=ACCESS_TOKEN";
  }
}
