package me.gaigeshen.wechat.mp.card.member;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 激活会员卡
 *
 * @author gaigeshen
 */
@Builder
public class MemberCardActiveRequest implements Request<MemberCardActiveResponse> {
  @JSONField(name = "membership_number") private String membershipNumber;
  @JSONField(name = "code") private String code;
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "background_pic_url") private String backgroundPicUrl;
  @JSONField(name = "activate_begin_time") private Long activateBeginTime;
  @JSONField(name = "activate_end_time") private Long activateEndTime;
  @JSONField(name = "init_bonus") private Integer initBonus;
  @JSONField(name = "init_bonus_record") private String initBonusRecord;
  @JSONField(name = "init_balance") private Integer initBalance;
  @JSONField(name = "init_custom_field_value1") private String initCustomFieldValue1;
  @JSONField(name = "init_custom_field_value2") private String initCustomFieldValue2;
  @JSONField(name = "init_custom_field_value3") private String initCustomFieldValue3;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/membercard/activate?access_token=ACCESS_TOKEN";
  }
}
