package me.gaigeshen.wechat.mp.card.member;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;

/**
 * 批量查询支付后投放会员卡券的规则
 *
 * @author gaigeshen
 */
public class PayGiftMemberCardBatchRequest implements Request<PayGiftMemberCardBatchResponse> {
  @JSONField(name = "type") private String type;
  @JSONField(name = "effective") private boolean effective;
  @JSONField(name = "offset") private int offset;
  @JSONField(name = "count") private int count;

  private PayGiftMemberCardBatchRequest(String type, boolean effective, int offset, int count) {
    this.type = type;
    this.effective = effective;
    this.offset = offset;
    this.count = count;
  }

  public static PayGiftMemberCardBatchRequest create(boolean effective, int offset, int count) {
    return new PayGiftMemberCardBatchRequest("RULE_TYPE_PAY_MEMBER_CARD", effective, offset, count);
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/paygiftcard/batchget?access_token=ACCESS_TOKEN";
  }
}
