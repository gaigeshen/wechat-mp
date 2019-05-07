package me.gaigeshen.wechat.mp.card.gift;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

import java.util.Map;

/**
 * 礼品卡货架修改，请根据文档说明进行组装正确的格式
 *
 * @author gaigeshen
 */
@Builder
public class GiftCardLandingPageUpdateRequest implements Request<GiftCardLandingPageUpdateResponse> {

  @JSONField(name = "page")
  private Map<String, Object> page;

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/giftcard/page/update?access_token=ACCESS_TOKEN";
  }
}
