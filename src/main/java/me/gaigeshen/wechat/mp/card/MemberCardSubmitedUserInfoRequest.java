package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 通过票据获取会员卡用户已提交信息。用户填写并提交开卡资料后，会跳转到商户的网页，并且会将票据带入。
 *
 * @author gaigeshen
 */
@Builder
public class MemberCardSubmitedUserInfoRequest implements Request<MemberCardSubmitedUserInfoResponse> {
  @JSONField(name = "activate_ticket")
  private String ticket;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/membercard/activatetempinfo/get?access_token=ACCESS_TOKEN";
  }
}
