package me.gaigeshen.wechat.mp.menu;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 菜单查询
 *
 * @author gaigeshen
 */
public class MenuQueryRequest implements Request<MenuQueryResponse> {
  @Override
  public Class<MenuQueryResponse> responseType() {
    return MenuQueryResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
  }
}
