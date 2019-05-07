package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取用户已领取卡券结果
 *
 * @author gaigeshen
 */
@Getter
public class UserCardResponse extends AbstractResponse {

  @JSONField(name = "card_list")
  private Card[] card;

  @JSONField(name = "has_share_card")
  private Boolean hasShareCard;

  public static class Card {
    @JSONField(name = "card_id") private String cardId;
    @JSONField(name = "code") private String code;
  }
}
