package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 创建货架
 *
 * @author gaigeshen
 */
@Getter
public class LandingPageCreateRequest implements Request<LandingPageCreateResponse> {
  @JSONField(name = "banner") private String banner;
  @JSONField(name = "title") private String title;
  @JSONField(name = "can_share") private boolean canShare;
  @JSONField(name = "scene") private String scene;
  @JSONField(name = "card_list") private List<Map<String, Object>> cardList;

  private LandingPageCreateRequest(String banner, String title, boolean canShare, String scene, List<Map<String, Object>> cardList) {
    this.banner = banner;
    this.title = title;
    this.canShare = canShare;
    this.scene = scene;
    this.cardList = cardList;
  }

  /**
   * 创建货架创建请求
   *
   * @param banner 页面顶部图片
   * @param title 页面标题
   * @param canShare 该页面是否可分享
   * @param scene 投放页面的场景值
   * @param cardId 投放的卡券编号
   * @param thumbUrl 卡券缩略图
   * @return 货架创建请求
   */
  public static LandingPageCreateRequest create(String banner, String title, boolean canShare, String scene, String cardId, String thumbUrl) {
    List<Map<String, Object>> cardList = new ArrayList<>();
    cardList.add(MapBuilder.builder(1).put("card_id", cardId).put("thumb_url", thumbUrl).build());
    return new LandingPageCreateRequest(banner, title, canShare, scene, cardList);
  }

  /**
   * 添加卡券
   *
   * @param cardId 卡券编号
   * @param thumbUrl 卡券缩略图
   * @return 当前的请求
   */
  public LandingPageCreateRequest addCard(String cardId, String thumbUrl) {
    cardList.add(MapBuilder.builder(1).put("card_id", cardId).put("thumb_url", thumbUrl).build());
    return this;
  }

  @Override
  public Class<LandingPageCreateResponse> responseType() {
    return LandingPageCreateResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/landingpage/create?access_token=$TOKEN";
  }
}
