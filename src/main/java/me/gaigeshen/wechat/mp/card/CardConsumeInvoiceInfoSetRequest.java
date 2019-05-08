package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.Map;

/**
 * 设置开票页面信息
 *
 * @author gaigeshen
 */
public class CardConsumeInvoiceInfoSetRequest implements Request<CardConsumeInvoiceInfoSetResponse> {

  @JSONField(name = "auth_field")
  private Map<String, Object> invoiceInfo;

  private CardConsumeInvoiceInfoSetRequest(Map<String, Object> invoiceInfo) {
    this.invoiceInfo = invoiceInfo;
  }

  /**
   * 创建设置开票页面信息请求
   *
   * @param userFields 用户字段
   * @param companyFields 单位字段
   * @param userCustomFields 用户自定义字段
   * @param companyCustomFields 单位自定义字段
   * @return 设置开票页面信息请求
   *
   * @see #userFieldsBuilder()
   * @see #companyFieldsBuilder()
   */
  public static CardConsumeInvoiceInfoSetRequest create(UserFields userFields, CompanyFields companyFields,
                                                        Map<String, Object> userCustomFields, Map<String, Object> companyCustomFields) {
    return new CardConsumeInvoiceInfoSetRequest(MapBuilder.builder(2)
            .put("user_field", MapBuilder.builder(4)
                    .put("show_title", userFields.showTitle ? 1: 0)
                    .put("show_phone", userFields.showPhone ? 1: 0)
                    .put("show_email", userFields.showEmail ? 1: 0)
                    .put("custom_field", userCustomFields)
                    .build())
            .put("biz_field", MapBuilder.builder(7)
                    .put("show_title", companyFields.showTitle ? 1: 0)
                    .put("show_tax_no", companyFields.showTaxNo ? 1: 0)
                    .put("show_addr", companyFields.showAddr ? 1: 0)
                    .put("show_phone", companyFields.showPhone ? 1: 0)
                    .put("show_bank_type", companyFields.showBankType ? 1: 0)
                    .put("show_bank_no", companyFields.showBankNo ? 1: 0)
                    .put("custom_field", companyCustomFields)
                    .build())
            .build());
  }

  /**
   * 返回用户字段构建器
   *
   * @return 用户字段构建器
   */
  public static UserFields.UserFieldsBuilder userFieldsBuilder() {
    return UserFields.builder();
  }

  /**
   * 返回单位字段构建器
   *
   * @return 单位字段构建器
   */
  public static CompanyFields.CompanyFieldsBuilder companyFieldsBuilder() {
    return CompanyFields.builder();
  }

  @Builder
  private static class UserFields {
    @JSONField(name = "auth_field") private boolean showTitle;
    @JSONField(name = "auth_field") private boolean showPhone;
    @JSONField(name = "auth_field") private boolean showEmail;
  }

  @Builder
  private static class CompanyFields {
    @JSONField(name = "auth_field") private boolean showTitle;
    @JSONField(name = "auth_field") private boolean showTaxNo;
    @JSONField(name = "auth_field") private boolean showAddr;
    @JSONField(name = "auth_field") private boolean showPhone;
    @JSONField(name = "auth_field") private boolean showBankType;
    @JSONField(name = "auth_field") private boolean showBankNo;
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/invoice/setbizattr?action=set_auth_field&access_token=ACCESS_TOKEN";
  }
}
