package me.gaigeshen.wechat.mp.card.member;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 通过票据获取会员卡用户已提交信息结果
 *
 * @author gaigeshen
 */
@Getter
public class MemberCardSubmitedUserInfoResponse extends AbstractResponse {

  @JSONField(name = "info")
  private Info info;

  public static class Info {
    @JSONField(name = "common_field_list") private CommonField[] commonFields;
  }
  public static class CommonField {
    @JSONField(name = "name") private String name;
    @JSONField(name = "value") private String value;
  }
}
