package me.gaigeshen.wechat.mp.customerservice;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 删除客服帐号
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class KefuAccountDeleteRequest implements Request<KefuAccountDeleteResponse> {
  @JSONField(name = "kf_account")
  private String account;

  private String nickname;
  private String password;

  @Override
  public Class<KefuAccountDeleteResponse> responseType() {
    return KefuAccountDeleteResponse.class;
  }

  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN";
  }
}
