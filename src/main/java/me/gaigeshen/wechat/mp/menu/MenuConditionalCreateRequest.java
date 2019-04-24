package me.gaigeshen.wechat.mp.menu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 个性化菜单创建
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class MenuConditionalCreateRequest implements Request<MenuConditionalCreateResponse> {
  @JSONField(name = "button")
  private Menu[] menus;
  @JSONField(name = "matchrule")
  private MenuConditional conditional;
  @Override
  public Class<MenuConditionalCreateResponse> responseType() {
    return MenuConditionalCreateResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=ACCESS_TOKEN";
  }
}
