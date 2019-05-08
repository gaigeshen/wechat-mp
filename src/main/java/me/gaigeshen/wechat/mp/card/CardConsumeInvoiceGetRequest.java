package me.gaigeshen.wechat.mp.card;

import me.gaigeshen.wechat.mp.Request;

/**
 * 查询支付后开票功能信息
 *
 * @author gaigeshen
 */
public class CardConsumeInvoiceGetRequest implements Request<CardConsumeInvoiceGetResponse> {

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/invoice/setbizattr?action=get_pay_mch&access_token=ACCESS_TOKEN";
  }
}
