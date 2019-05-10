package me.gaigeshen.wechat.mp.kefu.newapi;

import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import org.apache.commons.lang3.Validate;

/**
 * 删除客服帐号
 *
 * @author gaigeshen
 */
public class KefuDeleteRequest implements Request<EmptyDataResponse> {
  private final String account;

  private KefuDeleteRequest(String account) {
    Validate.notBlank(account, "account is required");
    this.account = account;
  }
  public static KefuDeleteRequest create(String account) {
    return new KefuDeleteRequest(account);
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN&kf_account=" + account;
  }
}
