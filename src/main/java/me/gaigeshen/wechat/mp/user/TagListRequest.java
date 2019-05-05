package me.gaigeshen.wechat.mp.user;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取标签列表
 *
 * @author gaigeshen
 */
public class TagListRequest implements Request<TagListResponse> {
  @Override
  public Class<TagListResponse> responseType() {
    return TagListResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN";
  }
}
