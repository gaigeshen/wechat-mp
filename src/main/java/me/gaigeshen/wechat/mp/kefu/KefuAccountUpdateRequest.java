package me.gaigeshen.wechat.mp.kefu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 修改客服帐号
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class KefuAccountUpdateRequest implements Request<KefuAccountUpdateResponse> {
  @JSONField(name = "kf_account")
  private String account;

  private String nickname;
  private String password;

  @Override
  public Class<KefuAccountUpdateResponse> responseType() {
    return KefuAccountUpdateResponse.class;
  }

  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";
  }
}
