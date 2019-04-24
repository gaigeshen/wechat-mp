package me.gaigeshen.wechat.mp.menu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * 菜单
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class Menu {
  // 菜单类型常量
  private static final String TYPE_CLICK = "click";
  private static final String TYPE_VIEW = "view";
  private static final String TYPE_SCANCODE_PUSH = "scancode_push";
  private static final String TYPE_SCANCODE_WAITMSG = "scancode_waitmsg";
  private static final String TYPE_PIC_SYSPHOTO = "pic_sysphoto";
  private static final String TYPE_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
  private static final String TYPE_PIC_WEIXIN = "pic_weixin";
  private static final String TYPE_LOCATION_SELECT = "location_select";
  private static final String TYPE_MEDIA_ID = "media_id";
  private static final String TYPE_VIEW_LIMITED = "view_limited";
  private static final String TYPE_MINIAPP = "miniprogram";

  // 菜单属性，不同的菜单类型拥有不同的菜单属性值
  private String type; // 菜单类型
  private String name; // 菜单名称，将显示在菜单上
  private String key;  // 事件推送用
  private String url;  // 菜单类型为跳转页面时有用
  private String appid;// 菜单类型为小程序时有用
  @JSONField(name = "pagepath") private String pagePath; // 菜单类型为小程序时有用
  @JSONField(name = "media_id") private String mediaId;
  @JSONField(name = "sub_button") private List<Menu> children;

  /**
   * 不要调用此方法，此方法存在的唯一目的是查询菜单的时候自动实例化用。
   */
  public Menu() {}

  private Menu(String type, String name,
               String key, String url,
               String appid, String pagePath,
               String mediaId, List<Menu> children) {
    this.type = type;
    this.name = name;
    this.key = key;
    this.url = url;
    this.appid = appid;
    this.pagePath = pagePath;
    this.mediaId = mediaId;
    this.children = children;
  }

  public static Menu click(String name, String key, Menu... children) {
    return appendChildren(Menu.builder().type(TYPE_CLICK).name(name).key(key), children);
  }
  public static Menu view(String name, String url, Menu... children) {
    return appendChildren(Menu.builder().type(TYPE_VIEW).name(name).url(url), children);
  }
  public static Menu scanCodePush(String name, String key, Menu... children) {
    return appendChildren(Menu.builder().type(TYPE_SCANCODE_PUSH).name(name).key(key), children);
  }
  public static Menu scanCodeWaitMsg(String name, String key, Menu... children) {
    return appendChildren(Menu.builder().type(TYPE_SCANCODE_WAITMSG).name(name).key(key), children);
  }
  public static Menu picSysPhoto(String name, String key, Menu... children) {
    return appendChildren(Menu.builder().type(TYPE_PIC_SYSPHOTO).name(name).key(key), children);
  }
  public static Menu picPhotoOrAlbum(String name, String key, Menu... children) {
    return appendChildren(Menu.builder().type(TYPE_PIC_PHOTO_OR_ALBUM).name(name).key(key), children);
  }
  public static Menu picWeixin(String name, String key, Menu... children) {
    return appendChildren(Menu.builder().type(TYPE_PIC_WEIXIN).name(name).key(key), children);
  }
  public static Menu locationSelect(String name, String key, Menu... children) {
    return appendChildren(Menu.builder().type(TYPE_LOCATION_SELECT).name(name).key(key), children);
  }
  public static Menu mediaId(String name, String mediaId, Menu... children) {
    return appendChildren(Menu.builder().type(TYPE_MEDIA_ID).name(name).mediaId(mediaId), children);
  }
  public static Menu viewLimited(String name, String mediaId, Menu... children) {
    return appendChildren(Menu.builder().type(TYPE_VIEW_LIMITED).name(name).mediaId(mediaId), children);
  }
  public static Menu miniProgram(String name, String url, String appid, String pagePath, Menu... children) {
    return appendChildren(Menu.builder().name(name).url(url).appid(appid).pagePath(pagePath), children);
  }

  /**
   * 设置子菜单
   *
   * @param builder 菜单构建器
   * @param children 子菜单集合
   * @return 当前的菜单
   */
  private static Menu appendChildren(MenuBuilder builder, Menu... children) {
    if (children != null && children.length > 0) {
      builder.children(Arrays.asList(children));
    }
    return builder.build();
  }
}
