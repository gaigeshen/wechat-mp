package me.gaigeshen.wechat.mp.kefu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;

/**
 * 获取所有的客服帐号
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class KefuAccountListRequest implements Request<KefuAccountListResponse> {
  @JSONField(name = "kf_account")
  private String account;

  private String nickname;
  private String password;

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
  }
}
