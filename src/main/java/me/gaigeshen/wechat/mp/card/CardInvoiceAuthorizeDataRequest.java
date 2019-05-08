package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 查询开票信息
 *
 * @author gaigeshen
 */
@Builder
public class CardInvoiceAuthorizeDataRequest implements Request<CardInvoiceAuthorizeDataResponse> {
  @JSONField(name = "order_id") private String orderId;
  @JSONField(name = "s_appid") private String sappid;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/invoice/getauthdata?access_token=ACCESS_TOKEN";
  }
}