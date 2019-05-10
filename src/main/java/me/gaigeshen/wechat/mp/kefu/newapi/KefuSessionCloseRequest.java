package me.gaigeshen.wechat.mp.kefu.newapi;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;

/**
 * 关闭客服会话
 *
 * @author gaigeshen
 */
@Builder
public class KefuSessionCloseRequest implements Request<EmptyDataResponse> {
  @JSONField(name = "kf_account")
  private String account;
  private String openid;
  @Override
  public String requestUri() {
    return "https: //api.weixin.qq.com/customservice/kfsession/close?access_token=ACCESS_TOKEN";
  }
}
