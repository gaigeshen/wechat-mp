package me.gaigeshen.wechat.mp.user;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import me.gaigeshen.wechat.mp.commons.MapBuilder;
import org.apache.commons.lang3.Validate;

import java.util.Map;

/**
 * 标签创建
 *
 * @author gaigeshen
 */
public class TagCreateRequest implements Request<TagCreateResponse> {
  private Map<String, Object> tag;
  public TagCreateRequest(String name) {
    Validate.notBlank(name, "tag name is required");
    this.tag = MapBuilder.builder(1).put("name", name).build();
  }
  @Override
  public Class<TagCreateResponse> responseType() {
    return TagCreateResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN";
  }
}
