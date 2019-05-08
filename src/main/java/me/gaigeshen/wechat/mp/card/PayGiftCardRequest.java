package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 查询支付后投放卡券的规则
 *
 * @author gaigeshen
 */
@Builder
public class PayGiftCardRequest implements Request<PayGiftCardResponse> {
  @JSONField(name = "rule_id")
  private long ruleId;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/paygiftcard/getbyid?access_token=ACCESS_TOKEN";
  }
}
