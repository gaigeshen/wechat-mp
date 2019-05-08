package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.Map;

/**
 * 设置支付后开票功能
 *
 * @author gaigeshen
 */
public class CardConsumeInvoiceSetRequest implements Request<CardConsumeInvoiceSetResponse> {

  @JSONField(name = "paymch_info")
  private Map<String, Object> paymchInfo;

  private CardConsumeInvoiceSetRequest(Map<String, Object> paymchInfo) {
    this.paymchInfo = paymchInfo;
  }

  /**
   * 创建设置支付后开票功能请求
   *
   * @param mchId 微信支付商户号
   * @param sappid 开票平台编号
   * @return 设置支付后开票功能请求
   */
  public static CardConsumeInvoiceSetRequest create(String mchId, String sappid) {
    return new CardConsumeInvoiceSetRequest(MapBuilder.builder(2)
            .put("mchid", mchId)
            .put("s_pappid", sappid)
            .build());
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/invoice/setbizattr?action=set_pay_mch&access_token=ACCESS_TOKEN";
  }
}
