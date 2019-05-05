package me.gaigeshen.wechat.mp.user;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.Map;

/**
 * 删除标签
 *
 * @author gaigeshen
 */
public class TagDeleteRequest implements Request<TagDeleteResponse> {
  private Map<String, Object> tag;
  public TagDeleteRequest(long id) {
    this.tag = MapBuilder.builder(1).put("id", id).build();
  }
  @Override
  public Class<TagDeleteResponse> responseType() {
    return TagDeleteResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=ACCESS_TOKEN";
  }
}
