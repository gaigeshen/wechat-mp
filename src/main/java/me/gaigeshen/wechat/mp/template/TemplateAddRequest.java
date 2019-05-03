package me.gaigeshen.wechat.mp.template;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获得模板
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class TemplateAddRequest implements Request<TemplateAddResponse> {
  @JSONField(name = "template_id_short")
  private String templateIdShort;
  @Override
  public Class<TemplateAddResponse> responseType() {
    return TemplateAddResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
  }
}
