package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;

/**
 * 更新会员信息
 *
 * @author gaigeshen
 */
public class MemberCardUpdateRequest implements Request<MemberCardUpdateResponse> {
  @JSONField(name = "code") private String code;
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "background_pic_url") private String backgroundPicUrl;
  @JSONField(name = "record_bonus") private String recordBonus;
  @JSONField(name = "bonus") private Integer bonus;
  @JSONField(name = "add_bonus") private Integer addBonus;
  @JSONField(name = "balance") private Integer balance;
  @JSONField(name = "add_balance") private Integer addBalance;
  @JSONField(name = "record_balance") private String recordBalance;
  @JSONField(name = "custom_field_value1") private String customFieldValue1;
  @JSONField(name = "custom_field_value2") private String customFieldValue2;

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/membercard/updateuser?access_token=ACCESS_TOKEN";
  }
}
