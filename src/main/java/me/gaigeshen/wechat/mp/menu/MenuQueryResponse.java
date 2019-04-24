package me.gaigeshen.wechat.mp.menu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 菜单查询结果
 *
 * @author gaigeshen
 */
@Getter
public class MenuQueryResponse extends AbstractResponse {

  private Menu menu;

  @JSONField(name = "conditionalmenu")
  private ConditionalMenu[] conditionalMenus;

  @Getter
  public static class Menu {
    @JSONField(name = "button")
    private me.gaigeshen.wechat.mp.menu.Menu[] menus;

    @JSONField(name = "menuid")
    private String menuId;
  }
  @Getter
  public static class ConditionalMenu {
    @JSONField(name = "button")
    private me.gaigeshen.wechat.mp.menu.Menu[] menus;

    @JSONField(name = "matchrule")
    private MenuConditional menuConditional;

    @JSONField(name = "menuid")
    private String menuId;
  }
}
