package me.gaigeshen.wechat.mp.menu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 菜单创建
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class MenuCreateRequest implements Request<MenuCreateResponse> {
  @JSONField(name = "button")
  private Menu[] menus;
  @Override
  public Class<MenuCreateResponse> responseType() {
    return MenuCreateResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
  }
}
