package me.gaigeshen.wechat.mp.card.gift;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 礼品卡货架创建结果
 *
 * @author gaigeshen
 */
@Getter
public class GiftCardLandingPageCreateResponse extends AbstractResponse {
  @JSONField(name = "page_id")
  private String pageId;
}
