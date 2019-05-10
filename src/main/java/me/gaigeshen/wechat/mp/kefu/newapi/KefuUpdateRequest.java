package me.gaigeshen.wechat.mp.kefu.newapi;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;

/**
 * 更新客服信息
 *
 * @author gaigeshen
 */
@Builder
public class KefuUpdateRequest implements Request<EmptyDataResponse> {
  @JSONField(name = "kf_account")
  private String account;
  private String nickname;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";
  }
}
