package me.gaigeshen.wechat.mp.menu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;

/**
 * 个性化菜单的条件
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class MenuConditional {
  @JSONField(name = "tag_id") private String tagId;
  private String sex;

  private String country;
  private String province;

  private String city;
  @JSONField(name = "client_platform_type") private String clientPlatformType;

  private String language;

  /**
   * 不要调用此方法，此方法存在的唯一目的是查询菜单的时候自动实例化用。
   */
  public MenuConditional() {}

  private MenuConditional(String tagId, String sex, String country, String province, String city, String clientPlatformType, String language) {
    this.tagId = tagId;
    this.sex = sex;
    this.country = country;
    this.province = province;
    this.city = city;
    this.clientPlatformType = clientPlatformType;
    this.language = language;
  }
}
