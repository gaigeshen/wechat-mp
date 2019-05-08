package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询开票信息结果
 *
 * @author gaigeshen
 */
@Getter
public class CardInvoiceAuthorizeDataResponse extends AbstractResponse {
  @JSONField(name = "invoice_status") private String invoiceStatus;
  @JSONField(name = "auth_time") private Long authTime;
  @JSONField(name = "user_auth_info") private InvoiceInfo invoiceInfo;

  @Getter
  public static class InvoiceInfo {
    @JSONField(name = "user_field") private UserFieldsValue userFieldsValue;
    @JSONField(name = "biz_field") private CompanyFieldsValue companyFieldsValue;
  }
  @Getter
  public static class UserFieldsValue {
    @JSONField(name = "title") private String title;
    @JSONField(name = "phone") private String phone;
    @JSONField(name = "email") private String email;
    @JSONField(name = "custom_field") private CustomFieldsValue[] customFieldsValues;
  }
  @Getter
  public static class CompanyFieldsValue {
    @JSONField(name = "title") private String title;
    @JSONField(name = "tax_no") private String taxNo;
    @JSONField(name = "addr") private String addr;
    @JSONField(name = "phone") private String phone;
    @JSONField(name = "bank_type") private String bankType;
    @JSONField(name = "bank_no") private String bankNo;
    @JSONField(name = "custom_field") private CustomFieldsValue[] customFieldsValues;
  }
  @Getter
  public static class CustomFieldsValue {
    @JSONField(name = "key") private String key;
    @JSONField(name = "value") private String value;
  }
}
