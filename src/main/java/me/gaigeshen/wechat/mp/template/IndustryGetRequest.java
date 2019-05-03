package me.gaigeshen.wechat.mp.template;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取所属行业
 *
 * @author gaigeshen
 */
public class IndustryGetRequest implements Request<IndustryGetResponse> {
  @Override
  public Class<IndustryGetResponse> responseType() {
    return IndustryGetResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
  }
}
