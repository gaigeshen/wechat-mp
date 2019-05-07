package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 核销卡券结果
 *
 * @author gaigeshen
 */
@Getter
public class CodeWriteoffResponse extends AbstractResponse {

  private Card card;

  public static class Card {
    @JSONField(name = "card_id") private String cardId;
    @JSONField(name = "openid") private String openid;
  }
}
