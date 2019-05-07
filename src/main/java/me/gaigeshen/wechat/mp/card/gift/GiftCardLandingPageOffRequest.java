package me.gaigeshen.wechat.mp.card.gift;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;

/**
 * 下架礼品卡货架
 *
 * @author gaigeshen
 */
public class GiftCardLandingPageOffRequest implements Request<GiftCardLandingPageOffResponse> {

  @JSONField(name = "page_id") private String pageId;
  @JSONField(name = "maintain") private Boolean maintain;
  @JSONField(name = "all") private Boolean all;

  private GiftCardLandingPageOffRequest(String pageId, Boolean maintain, Boolean all) {
    this.pageId = pageId;
    this.maintain = maintain;
    this.all = all;
  }

  /**
   * 创建下架礼品卡货架
   *
   * @param pageId 货架编号
   * @return 下架礼品卡货架请求
   */
  public static GiftCardLandingPageOffRequest create(String pageId) {
    return new GiftCardLandingPageOffRequest(pageId, true, null);
  }

  /**
   * 创建下架礼品卡货架，下架所有货架
   *
   * @return 下架礼品卡货架请求
   */
  public static GiftCardLandingPageOffRequest createOffAll() {
    return new GiftCardLandingPageOffRequest(null, true, true);
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/giftcard/maintain/set?access_token=ACCESS_TOKEN";
  }
}
