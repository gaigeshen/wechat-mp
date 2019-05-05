package me.gaigeshen.wechat.mp.user;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import me.gaigeshen.wechat.mp.commons.MapBuilder;
import org.apache.commons.lang3.Validate;

import java.util.Map;

/**
 * 编辑标签
 *
 * @author gaigeshen
 */
public class TagUpdateRequest implements Request<TagUpdateResponse> {
  private Map<String, Object> tag;
  public TagUpdateRequest(long id, String name) {
    Validate.notBlank(name, "tag name is required");
    this.tag = MapBuilder.builder(2).put("name", name).put("id", id).build();
  }
  @Override
  public Class<TagUpdateResponse> responseType() {
    return TagUpdateResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN";
  }
}
