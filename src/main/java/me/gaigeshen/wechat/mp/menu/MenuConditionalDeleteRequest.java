package me.gaigeshen.wechat.mp.menu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 个性化菜单删除
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class MenuConditionalDeleteRequest implements Request<MenuConditionalDeleteResponse> {
  @JSONField(name = "menuid")
  private String menuId;
  @Override
  public Class<MenuConditionalDeleteResponse> responseType() {
    return MenuConditionalDeleteResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=ACCESS_TOKEN";
  }
}
