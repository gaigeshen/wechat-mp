package me.gaigeshen.wechat.mp.template;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取模板列表，获取已添加至帐号下所有模板列表
 *
 * @author gaigeshen
 */
public class TemplateGetRequest implements Request<TemplateGetResponse> {
  @Override
  public Class<TemplateGetResponse> responseType() {
    return TemplateGetResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
  }
}
