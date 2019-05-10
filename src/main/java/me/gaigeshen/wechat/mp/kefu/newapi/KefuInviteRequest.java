package me.gaigeshen.wechat.mp.kefu.newapi;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;

/**
 * 邀请绑定客服帐号
 *
 * @author gaigeshen
 */
@Builder
public class KefuInviteRequest implements Request<EmptyDataResponse> {
  @JSONField(name = "kf_account")
  private String account;
  @JSONField(name = "invite_wx")
  private String inviteWx;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/customservice/kfaccount/inviteworker?access_token=ACCESS_TOKEN";
  }
}
