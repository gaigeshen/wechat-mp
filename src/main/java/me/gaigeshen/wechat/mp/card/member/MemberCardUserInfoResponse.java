package me.gaigeshen.wechat.mp.card.member;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取会员信息结果
 *
 * @author gaigeshen
 */
@Getter
public class MemberCardUserInfoResponse extends AbstractResponse {
  @JSONField(name = "openid") private String openid;
  @JSONField(name = "nickname") private String nickname;
  @JSONField(name = "membership_number") private String membershipNumber;
  @JSONField(name = "bonus") private Integer bonus;
  @JSONField(name = "sex") private String sex;
  @JSONField(name = "user_card_status") private String userCardStatus;
  @JSONField(name = "has_active") private Boolean actived;
  @JSONField(name = "userInfo") private UserInfo userInfo;

  public static class UserInfo {
    @JSONField(name = "common_field_list") private CommonField[] commonFields;
  }
  public static class CommonField {
    @JSONField(name = "name") private String name;
    @JSONField(name = "value") private String value;
  }
}
