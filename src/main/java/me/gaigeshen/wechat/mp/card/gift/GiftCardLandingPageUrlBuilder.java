package me.gaigeshen.wechat.mp.card.gift;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.Collections;

/**
 * 礼品卡货架链接构建器
 *
 * @author gaigeshen
 */
public class GiftCardLandingPageUrlBuilder {
  private static final String BASE_URL = "https://mp.weixin.qq.com/bizmall/giftcard?action=homepage&";

  private final String pageId;

  private GiftCardLandingPageUrlBuilder(String pageId) {
    this.pageId = pageId;
  }

  public static GiftCardLandingPageUrlBuilder create(String pageId) {
    return new GiftCardLandingPageUrlBuilder(pageId);
  }

  public String build() {
    return BASE_URL +  URLEncodedUtils.format(
            Collections.singletonList(new BasicNameValuePair("page_id", pageId)), "utf-8")
            + "#wechat_redirect";
  }

}
