package me.gaigeshen.wechat.mp;

import me.gaigeshen.wechat.mp.accesstoken.AccessTokenRequest;
import me.gaigeshen.wechat.mp.accesstoken.AccessTokenResponse;
import me.gaigeshen.wechat.mp.commons.HttpClientExecutor;
import me.gaigeshen.wechat.mp.menu.*;
import me.gaigeshen.wechat.mp.sendall.ImageUploadRequest;
import me.gaigeshen.wechat.mp.sendall.ImageUploadResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author gaigeshen
 */
public class TestCase {
  private Config config;
  private RequestExecutor executor;

  @Before
  public void init() throws Exception {
    Properties props = new Properties();
    try (InputStream in = getClass().getResourceAsStream("/config.properties")) {
      props.load(in);
    }
    this.config = Config.builder()
            .appid(props.getProperty("appid"))
            .secret(props.getProperty("secret"))
            .token(props.getProperty("token"))
            .encodingAesKey(props.getProperty("encodingAesKey"))
            .build();
    this.executor = new RequestExecutor(new HttpClientExecutor(2000, 2000, 5000), config);
  }

  @After
  public void clean() throws IOException {
    this.executor.close();
  }

  @Test
  public void testAccessTokenRequest() { // 获取访问令牌，一般无需使用者去调用获取
    AccessTokenRequest req = new AccessTokenRequest();
    AccessTokenResponse resp = executor.execute(req);
    System.out.println("accessToken: " + resp.getAccessToken());
    System.out.println("expiresIn: " + resp.getExpiresIn());
  }

  @Test
  public void testServerAddressRequest() { // 获取服务器地址集合
    ServerAddressRequest req = new ServerAddressRequest();
    ServerAddressResponse resp = executor.execute(req);
    if (resp.isSucceeded()) {
      for (String address : resp.getAddresses()) {
        System.out.println(address);
      }
    }
  }

  @Test
  public void testNetworkCheckRequest() { // 网络检测
    NetworkCheckRequest req = NetworkCheckRequest.builder()
            // dns（做域名解析）、ping（做ping检测）、all（dns和ping都做）
            .action("all")
            // CHINANET（电信出口）、UNICOM（联通出口）、CAP（腾讯自建出口）、DEFAULT（根据ip来选择运营商）
            .checkOperator("DEFAULT")
            .build();
    NetworkCheckResponse resp = executor.execute(req);
    if (resp.isSucceeded()) {
      System.out.println(Arrays.toString(resp.getDns()));
      System.out.println(Arrays.toString(resp.getPing()));
    } else {
      System.out.println("error code: " + resp.getErrorCode());
      System.out.println("error message: " + resp.getErrorMessage());
    }
  }

  @Test
  public void testMenuCreateRequest() { // 创建菜单
    Menu[] menus = new Menu[3]; // 最多三个一级菜单
    menus[0] = Menu.click("点击推事件", "click_key",
            Menu.picPhotoOrAlbum("拍照或者相册", "pic_photo_or_album_key"),
            Menu.view("跳转页面", "https://ip138.com"),
            Menu.picWeixin("微信相册发图", "pic_weixin_key")); // 三个子集菜单，最多五个子集菜单

    menus[1] = Menu.view("跳转页面", "https://baidu.com");
    menus[2] = Menu.picSysPhoto("系统拍照", "pic_sys_photo_key");

    MenuCreateRequest req = MenuCreateRequest.builder()
            .menus(menus)
            .build();
    MenuCreateResponse resp = executor.execute(req);
    System.out.println("error code: " + resp.getErrorCode());
    System.out.println("error message: " + resp.getErrorMessage());
  }

  @Test
  public void testMenuConditionalCreateRequest() { // 个性化菜单创建
    Menu[] menus = new Menu[3]; // 最多三个一级菜单
    menus[0] = Menu.click("点击推", "click_key",
            Menu.picPhotoOrAlbum("拍照或者相册", "pic_photo_or_album_key"),
            Menu.view("跳转页面", "https://ip138.com"),
            Menu.picWeixin("微信相册发图", "pic_weixin_key")); // 三个子集菜单，最多五个子集菜单

    menus[1] = Menu.view("跳转页面", "https://baidu.com");
    menus[2] = Menu.picSysPhoto("系统拍照", "pic_sys_photo_key");
    MenuConditionalCreateRequest req = MenuConditionalCreateRequest.builder()
            .menus(menus)
            .conditional(MenuConditional.builder().city("杭州").country("中国").province("浙江").build())
            .build();
    MenuConditionalCreateResponse resp = executor.execute(req);
    System.out.println("error code: " + resp.getErrorCode());
    System.out.println("error message: " + resp.getErrorMessage());
    System.out.println("menu id " + resp.getMenuId());
  }

  @Test
  public void testMenuConditionalDeleteRequest() { // 删除个性化菜单
    MenuConditionalDeleteRequest req = MenuConditionalDeleteRequest.builder()
            .menuId("457268683") // 创建个性化菜单时会返回
            .build();
    MenuConditionalDeleteResponse resp = executor.execute(req);
    System.out.println("error code: " + resp.getErrorCode());
    System.out.println("error message: " + resp.getErrorMessage());
  }

  @Test
  public void testMenuConditionalTryMatchRequest() { // 测试个性化菜单匹配，获取某个用户的菜单
    MenuConditionalTryMatchRequest req = MenuConditionalTryMatchRequest.builder()
            .userId("ocOGR0U4M7EbZEVpMKqR0yMGADSE") // 可以是粉丝的微信号或者openid
            .build();
    MenuConditionalTryMatchResponse resp = executor.execute(req);
    System.out.println("error code: " + resp.getErrorCode());
    System.out.println("error message: " + resp.getErrorMessage());
    System.out.println("menus: " + Arrays.toString(resp.getMenus()));
  }

  @Test
  public void testMenuQueryRequest() { // 查询菜单，包含个性化菜单和普通菜单
    MenuQueryRequest req = new MenuQueryRequest();
    MenuQueryResponse resp = executor.execute(req);
    System.out.println("error code: " + resp.getErrorCode());
    System.out.println("error message: " + resp.getErrorMessage());
    MenuQueryResponse.Menu menu = resp.getMenu();
    if (menu != null) {
      // 打印每个菜单的名称
      System.out.println("menus: " + Arrays.toString(Arrays.stream(menu.getMenus()).map(Menu::getName).toArray()));
    }
    System.out.println("=================== Conditional menu ============================");
    MenuQueryResponse.ConditionalMenu[] conditionalMenus = resp.getConditionalMenus();
    if (conditionalMenus != null) {
      for (MenuQueryResponse.ConditionalMenu conditionalMenu : conditionalMenus) {
        System.out.println("menus: " + Arrays.toString(Arrays.stream(conditionalMenu.getMenus()).map(Menu::getName).toArray()));
        System.out.println("menu conditional: " + conditionalMenu.getMenuConditional());
        System.out.println("menu id:  " + conditionalMenu.getMenuId());
      }
    }
  }

  @Test
  public void testMenuDeleteRequest() { // 删除菜单，会删除所有的菜单，包含普通菜单和个性化菜单，再次调用查询菜单，则会报错说不存在菜单
    MenuDeleteRequest req = new MenuDeleteRequest();
    MenuDeleteResponse resp = executor.execute(req);
    System.out.println("error code: " + resp.getErrorCode());
    System.out.println("error message: " + resp.getErrorMessage());
  }

  @Test
  public void testUploadImageRequest() throws IOException { // 群发接口，上传图文消息内的图片
    ImageUploadRequest req = ImageUploadRequest.builder()
            // 拥有多种形式的上传项目
            // 参考UploadItem的子类
            .media(new FileUploadItem("avatar.jpg",
                    new File("C:\\Users\\gaigeshen\\Pictures\\Saved Pictures\\avatar.jpg")))
            .build();
    ImageUploadResponse resp = executor.execute(req);
    System.out.println("error code: " + resp.getErrorCode());
    System.out.println("error message: " + resp.getErrorMessage());
    System.out.println("url: " + resp.getUrl());
  }

}
