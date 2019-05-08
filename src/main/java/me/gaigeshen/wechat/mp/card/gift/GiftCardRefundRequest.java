package me.gaigeshen.wechat.mp.card.gift;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 礼品卡退款
 *
 * @author gaigeshen
 */
@Builder
public class GiftCardRefundRequest implements Request<GiftCardRefundResponse> {
  @JSONField(name = "order_id")
  private String orderId;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/giftcard/order/refund?access_token=ACCESS_TOKEN";
  }
}
