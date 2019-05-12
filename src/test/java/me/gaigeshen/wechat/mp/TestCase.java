package me.gaigeshen.wechat.mp;

import me.gaigeshen.wechat.mp.accesstoken.AccessTokenRequest;
import me.gaigeshen.wechat.mp.accesstoken.AccessTokenResponse;
import me.gaigeshen.wechat.mp.commons.HttpClientExecutor;
import me.gaigeshen.wechat.mp.kefu.newapi.*;
import me.gaigeshen.wechat.mp.menu.*;
import me.gaigeshen.wechat.mp.sendall.ImageUploadRequest;
import me.gaigeshen.wechat.mp.sendall.ImageUploadResponse;
import me.gaigeshen.wechat.mp.smart.ocr.*;
import me.gaigeshen.wechat.mp.store.*;
import me.gaigeshen.wechat.mp.store.miniapp.StoreMiniappCategoryRequest;
import me.gaigeshen.wechat.mp.store.miniapp.StoreMiniappCategoryResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
    if (this.executor != null) {
      this.executor.close();
    }
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
  public void testUploadImageRequest() { // 群发接口，上传图文消息内的图片
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

  @Test
  public void testStoreImageUploadRequest() { // 门店图片上传
    StoreImageUploadRequest request = StoreImageUploadRequest.builder()
            .buffer(new FileUploadItem("store1.jpg", new File("C:\\Users\\gaigeshen\\Pictures\\Saved Pictures\\store1.jpg")))
            .build();
    StoreImageUploadResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
    System.out.println("url: " + response.getUrl());
  }

  @Test
  public void testStoreCreateRequest() { // 创建门店
    StoreCreateRequest request = StoreCreateRequest.create(StoreCreateRequest.baseInfoBuilder()
            .sid("sidabc123")
            .businessName("这是门店名称")
            .branchName("这是分店名称")
            .province("浙江省")
            .city("杭州市")
            .district("余杭区")
            .address("文一西路海创科技中心")
            .telephone("0571-88888888")
            .categories(new String[]{ "美食", "火锅" })
            .offsetType(1)
            .longitude(119.99563)
            .latitude(30.275415)
            .recommend("麦辣鸡腿堡套餐，麦乐鸡，全家桶")
            .special("免费wifi，大保健")
            .introduction("全球大型跨国连锁餐厅")
            .openTime("8:00-21:00")
            .avgPrice(99)
            // 通过门店图片上传接口获得的图片链接地址
            .photoUrls(StoreCreateRequest.createPhotoUrls(new String[]{
                    "http://mmbiz.qpic.cn/mmbiz_jpg/Zf3PN4ib2cdSof936uIfecrrtmtjVDHgPVjNeicq4Mgom37hpSEJyfFv1FxFBfHsNsxtzoqTrGxOaeiadxOw0eQpg/0",
                    "http://mmbiz.qpic.cn/mmbiz_jpg/Zf3PN4ib2cdSof936uIfecrrtmtjVDHgPjsib9DlTKvAWOomHcRJgodgRoxMlecOYdgbGibTnTHGhmHKXCiaibiaSFpQ/0"
            }))
            .build());
    StoreCreateResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
    System.out.println("poi id: " + response.getPoiId());
  }

  @Test
  public void testStoreCategoryRequest() { // 查询门店类目
    StoreCategoryRequest request = new StoreCategoryRequest();
    StoreCategoryResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
    System.out.println(Arrays.toString(response.getCategories()));
  }

  @Test
  public void testStoreMiniappCategoryRequest() { // 获取门店小程序类目
    StoreMiniappCategoryRequest request = new StoreMiniappCategoryRequest();
    StoreMiniappCategoryResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
  }

  @Test
  public void testSemantic() { // 测试语义理解，注意此处的请求方式
    // 此处的 EmptyDataResponse 仅仅是为了编译不报错，实际没有什么用处
    // 使用了打印结果内容的结果处理器
    executor.execute(new Request<EmptyDataResponse>() {
      private String query = "查一下明天从北京到上海的南航机票";
      private String city = "北京";
      private String category = "flight,hotel";
      private String appid = config.getAppid();
      private String uid = "ocOGR0U4M7EbZEVpMKqR0yMGADSE";

      @Override
      public String requestUri() {
        return "https://api.weixin.qq.com/semantic/semproxy/search?access_token=ACCESS_TOKEN";
      }
    }, new StringResponseBodyPrintHandler());
  }



  // ===================== 新版客服帐号测试 ==================================================
  @Test
  public void testKefuAddRequest() { // 添加客服帐号
    KefuAddRequest request = KefuAddRequest.builder()
            .account("ggs@hz-zkkj")
            .nickname("ggskefu")
            .build();
    EmptyDataResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
  }

  @Test
  public void testKefuAvatarUploadRequest() { // 上传客服头像
    KefuAvatarUploadRequest request = KefuAvatarUploadRequest.builder()
            .account("ggs@hz-zkkj")
            .media(new FileUploadItem("ggskefu.jpg",
                    new File("C:\\Users\\gaigeshen\\Pictures\\Saved Pictures\\avatar.jpg")))
            .build();
    EmptyDataResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
  }

  @Test
  public void testKefuDeleteRequest() { // 删除客服帐号
    KefuDeleteRequest request = KefuDeleteRequest.create("ggs@hz-zkkj");
    EmptyDataResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
  }

  @Test
  public void testKefuInviteRequest() { // 邀请客服绑定
    KefuInviteRequest request = KefuInviteRequest.builder()
            .account("ggs@hz-zkkj")
            .inviteWx("gaige_shen")
            .build();
    EmptyDataResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
  }

  @Test
  public void testKefuListRequest() { // 获取客服列表
    KefuListRequest request = new KefuListRequest();
    KefuListResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
    if (response.isSucceeded()) {
      KefuListResponse.Kefu[] kefus = response.getKefus();
      if (kefus != null) {
        for (KefuListResponse.Kefu kefu : kefus) {
          System.out.println("kefu account: " + kefu.getAccount());
          System.out.println("kefu avatar: " + kefu.getHeadimgurl());
          System.out.println("kefu id: " + kefu.getId());
          System.out.println("kefu nick: " + kefu.getNick());
          System.out.println("kefu wx: " + kefu.getWx());
        }
      }
    }
  }

  @Test
  public void testKefuOnlineListRequest() { // 获取在线客服列表
    KefuOnlineListRequest request = new KefuOnlineListRequest();
    KefuOnlineListResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
    if (response.isSucceeded()) {
      KefuOnlineListResponse.Kefu[] kefus = response.getKefus();
      if (kefus != null) {
        for (KefuOnlineListResponse.Kefu kefu : kefus) {
          System.out.println("kefu account: " + kefu.getAccount());
          System.out.println("kefu id: " + kefu.getId());
          System.out.println("kefu status: " + kefu.getStatus());
          System.out.println("kefu acceptedCase: " + kefu.getAcceptedCase());
        }
      }
    }
  }

  @Test
  public void testKefuUpdateRequest() { // 更新客服
    KefuUpdateRequest request = KefuUpdateRequest.builder()
            .account("ggs@hz-zkkj")
            .nickname("ggskefu_updated")
            .build();
    EmptyDataResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
  }



  // ===================== 智能接口测试 ==================================================

  @Test
  public void testBankCardReadRequest() {
    BankCardReadRequest request = BankCardReadRequest.builder()
            .img(new FileUploadItem("bank_card_abc.jpg",
                    new File("C:\\Users\\gaigeshen\\Pictures\\Saved Pictures\\bank_card_abc.jpg")))
            .build();
    BankCardReadResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
    System.out.println("bank card number: " + response.getNumber());
  }

  @Test
  public void testDrivingCardReadRequest() {
    DrivingCardReadRequest request = DrivingCardReadRequest.builder()
            .img(new FileUploadItem("driving_license.jpg",
                    new File("C:\\Users\\gaigeshen\\Pictures\\Saved Pictures\\driving_license.jpg")))
            .build();
    DrivingCardReadResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
    System.out.println("vin: " + response.getVin());
    System.out.println("plate no: " + response.getPlateNum());
    System.out.println("engine no: " + response.getEngineNum());
    System.out.println("vehicle type:  " + response.getVehicleType());
  }

  @Test
  public void testIdCardReadRequest() { // 身份证识别，正反都可以
    IdCardReadRequest request = IdCardReadRequest.builder()
            .img(new FileUploadItem("id_card.jpg",
                    new File("C:\\Users\\gaigeshen\\Pictures\\Saved Pictures\\id_card.jpg")))
            .build();
    IdCardReadResponse response = executor.execute(request);
    System.out.println("error code: " + response.getErrorCode());
    System.out.println("error message: " + response.getErrorMessage());
    System.out.println("type: " + response.getType());
    System.out.println("name: " + response.getName());
    System.out.println("id: " + response.getId());
    System.out.println("valid date: " + response.getValidDate());
  }
}

