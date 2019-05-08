package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 获取会员信息
 *
 * @author gaigeshen
 */
@Builder
public class MemberCardUserInfoRequest implements Request<MemberCardUserInfoResponse> {
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "code") private String code;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/membercard/userinfo/get?access_token=ACCESS_TOKEN";
  }
}
