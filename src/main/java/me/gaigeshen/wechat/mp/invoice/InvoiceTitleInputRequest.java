package me.gaigeshen.wechat.mp.invoice;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 将用户发票抬头信息录入
 *
 * @author gaigeshen
 */
@Builder
public class InvoiceTitleInputRequest implements Request<InvoiceTitleInputResponse> {
  @JSONField(name = "title") private String title;
  @JSONField(name = "phone") private String phone;
  @JSONField(name = "tax_no") private String taxNo;
  @JSONField(name = "addr") private String addr;
  @JSONField(name = "bank_type") private String bankType;
  @JSONField(name = "bank_no") private String bankNo;
  @JSONField(name = "user_fill") private int userFill;
  @JSONField(name = "out_title_id") private String outTitleId;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/invoice/biz/getusertitleurl?access_token=ACCESS_TOKEN";
  }
}
