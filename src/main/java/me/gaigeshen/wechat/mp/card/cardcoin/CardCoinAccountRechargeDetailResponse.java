package me.gaigeshen.wechat.mp.card.cardcoin;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询充值订单的状态结果
 *
 * @author gaigeshen
 */
@Getter
public class CardCoinAccountRechargeDetailResponse extends AbstractResponse {

  @JSONField(name = "order_info")
  private OrderInfo orderInfo;

  public static class OrderInfo {
    @JSONField(name = "order_id") private String orderId;
    @JSONField(name = "status") private String status;
    @JSONField(name = "create_time") private Long createTime;
    @JSONField(name = "pay_finish_time") private Long payFinishTime;
    @JSONField(name = "desc") private String desc;
    @JSONField(name = "free_coin_count") private Double freeCoinCount;
    @JSONField(name = "pay_coin_count") private Double payCoinCount;
    @JSONField(name = "refund_free_coin_count") private Double refundFreeCoinCount;
    @JSONField(name = "refund_pay_coin_count") private Double refundPayCoinCount;
    @JSONField(name = "openid") private String openid;
    @JSONField(name = "order_type") private String orderType;
  }
}
