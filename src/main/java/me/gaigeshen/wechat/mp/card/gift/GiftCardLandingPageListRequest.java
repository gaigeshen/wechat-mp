package me.gaigeshen.wechat.mp.card.gift;

import me.gaigeshen.wechat.mp.Request;

/**
 * 礼品卡货架列表获取
 *
 * @author gaigeshen
 */
public class GiftCardLandingPageListRequest implements Request<GiftCardLandingPageListResponse> {

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/giftcard/page/batchget?access_token=ACCESS_TOKEN";
  }
}
