package me.gaigeshen.wechat.mp.menu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 个性化菜单测试匹配结果
 *
 * @author gaigeshen
 */
@Getter
public class MenuConditionalTryMatchResponse extends AbstractResponse {
  @JSONField(name = "button")
  private Menu[] menus;
}
