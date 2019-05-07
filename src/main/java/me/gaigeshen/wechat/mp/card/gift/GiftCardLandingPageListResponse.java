package me.gaigeshen.wechat.mp.card.gift;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 礼品卡货架列表获取结果
 *
 * @author gaigeshen
 */
@Getter
public class GiftCardLandingPageListResponse extends AbstractResponse {
  @JSONField(name = "page_id_list")
  private String[] pageIdList;
}
