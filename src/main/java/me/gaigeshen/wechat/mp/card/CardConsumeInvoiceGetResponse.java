package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询支付后开票功能结果
 *
 * @author gaigeshen
 */
@Getter
public class CardConsumeInvoiceGetResponse extends AbstractResponse {

  @JSONField(name = "paymch_info")
  private PaymchInfo paymchInfo;

  public static class PaymchInfo {
    @JSONField(name = "mchid")
    private String mchId;
    @JSONField(name = "s_pappid")
    private String pappid;
  }
}
