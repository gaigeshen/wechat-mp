package me.gaigeshen.wechat.mp.store.miniapp;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 查询门店小程序审核结果
 *
 * @author gaigeshen
 */
public class StoreMiniappAuditRequest implements Request<StoreMiniappAuditResponse> {
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/wxa/get_merchant_audit_info?access_token=ACCESS_TOKEN";
  }
}
