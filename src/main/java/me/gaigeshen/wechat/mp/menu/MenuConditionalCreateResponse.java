package me.gaigeshen.wechat.mp.menu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 个性化菜单创建结果
 *
 * @author gaigeshen
 */
@Getter
public class MenuConditionalCreateResponse extends AbstractResponse {
  @JSONField(name = "menuid")
  private String menuId;
}
