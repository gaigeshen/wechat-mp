package me.gaigeshen.wechat.mp.menu;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 菜单删除
 *
 * @author gaigeshen
 */
public class MenuDeleteRequest implements Request<MenuDeleteResponse> {
  @Override
  public Class<MenuDeleteResponse> responseType() {
    return MenuDeleteResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
  }
}
