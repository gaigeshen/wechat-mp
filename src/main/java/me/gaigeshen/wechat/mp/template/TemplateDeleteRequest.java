package me.gaigeshen.wechat.mp.template;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 删除模板
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class TemplateDeleteRequest implements Request<TemplateDeleteResponse> {
  @JSONField(name = "template_id")
  private String templateId;
  @Override
  public Class<TemplateDeleteResponse> responseType() {
    return TemplateDeleteResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN";
  }
}
