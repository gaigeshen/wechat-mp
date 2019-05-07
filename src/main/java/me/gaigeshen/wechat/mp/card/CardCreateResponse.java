package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 创建卡券结果
 *
 * @author gaigeshen
 */
@Getter
public class CardCreateResponse extends AbstractResponse {
  @JSONField(name = "card_id")
  private String cardId;
}
