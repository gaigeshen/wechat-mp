package me.gaigeshen.wechat.mp.card.member;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.Map;

/**
 * 设置会员卡开卡字段
 *
 * @author gaigeshen
 */
public class MemberCardUserFormRequest implements Request<MemberCardUserFormResponse> {
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "service_statement") private ServiceStatement serviceStatement;
  @JSONField(name = "bind_old_card") private BindOldCard bindOldCard;
  @JSONField(name = "required_form") private Map<String, Object> requiredForm;
  @JSONField(name = "optional_form") private Map<String, Object> optionalForm;

  private MemberCardUserFormRequest(String cardId,
                                    ServiceStatement serviceStatement, BindOldCard bindOldCard,
                                    Map<String, Object> requiredForm, Map<String, Object> optionalForm) {
    this.cardId = cardId;
    this.serviceStatement = serviceStatement;
    this.bindOldCard = bindOldCard;
    this.requiredForm = requiredForm;
    this.optionalForm = optionalForm;
  }

  /**
   * 创建设置会员卡开卡字段请求
   *
   * @param cardId 卡券编号
   * @param serviceStatement 服务声明
   * @param bindOldCard 绑定老会员链接
   * @param required 会员卡激活时的必填选项
   * @param requiredCommonFieldsList 必填选项微信格式化的选项类型，见文档
   * @param requiredCanModify 必填选项是否可更改
   * @param optional 会员卡激活时的选填项
   * @param optionalCommonFieldsList 选填选项微信格式化的选项类型，见文档
   * @param optionalCanModify 选填选项是否可更改
   * @return 设置会员卡开卡字段请求
   */
  public static MemberCardUserFormRequest create(String cardId, ServiceStatement serviceStatement, BindOldCard bindOldCard,
                                                 RichField[] required, String[] requiredCommonFieldsList, boolean requiredCanModify,
                                                 RichField[] optional, String[] optionalCommonFieldsList, boolean optionalCanModify) {
    return new MemberCardUserFormRequest(cardId, serviceStatement, bindOldCard,
            MapBuilder.builder()
                    .put("can_modify", requiredCanModify)
                    .put("rich_field_list", required)
                    .put("common_field_id_list", requiredCommonFieldsList)
                    .build(),
            MapBuilder.builder()
                    .put("can_modify", optionalCanModify)
                    .put("rich_field_list", optional)
                    .put("common_field_id_list", optionalCommonFieldsList)
                    .build());
  }

  public static RichField.RichFieldBuilder richFieldBuilder() {
    return RichField.builder();
  }
  public static ServiceStatement.ServiceStatementBuilder serviceStatementBuilder() {
    return ServiceStatement.builder();
  }
  public static BindOldCard.BindOldCardBuilder bindOldCardBuilder() {
    return BindOldCard.builder();
  }

  @Builder
  private class RichField {
    /**
     * 1. FORM_FIELD_RADIO<br>
     * 2. FORM_FIELD_SELECT<br>
     * 3. FORM_FIELD_CHECK_BOX<br>
     */
    private String type;
    private String name;
    private String[] values;
  }
  @Builder
  private class ServiceStatement {
    private String name;
    private String url;
  }
  @Builder
  private class BindOldCard {
    private String name;
    private String url;
  }


  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/membercard/activateuserform/set?access_token=ACCESS_TOKEN";
  }
}
