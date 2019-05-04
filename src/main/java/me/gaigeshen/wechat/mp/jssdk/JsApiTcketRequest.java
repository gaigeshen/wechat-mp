package me.gaigeshen.wechat.mp.jssdk;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * @author gaigeshen
 */
public class JsApiTcketRequest implements Request<JsApiTcketResponse> {
  @Override
  public Class<JsApiTcketResponse> responseType() {
    return JsApiTcketResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
  }
}
