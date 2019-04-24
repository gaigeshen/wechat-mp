package me.gaigeshen.wechat.mp.menu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 个性化菜单测试匹配
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class MenuConditionalTryMatchRequest implements Request<MenuConditionalTryMatchResponse> {
  @JSONField(name = "user_id")
  private String userId;
  @Override
  public Class<MenuConditionalTryMatchResponse> responseType() {
    return MenuConditionalTryMatchResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=ACCESS_TOKEN";
  }
}
