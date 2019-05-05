package me.gaigeshen.wechat.mp.material;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取永久素材总数
 *
 * @author gaigeshen
 */
public class PermanentMediaCountRequest implements Request<PermanentMediaCountResponse> {
  @Override
  public Class<PermanentMediaCountResponse> responseType() {
    return PermanentMediaCountResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN";
  }
}
