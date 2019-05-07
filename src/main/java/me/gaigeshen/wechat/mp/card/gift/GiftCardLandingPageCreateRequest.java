package me.gaigeshen.wechat.mp.card.gift;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

import java.util.Map;

/**
 * 礼品卡货架创建，请根据文档说明进行组装正确的格式
 *
 * @author gaigeshen
 */
@Builder
public class GiftCardLandingPageCreateRequest implements Request<GiftCardLandingPageCreateResponse> {

  @JSONField(name = "page")
  private Map<String, Object> page;

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/giftcard/page/add?access_token=ACCESS_TOKEN";
  }
}
