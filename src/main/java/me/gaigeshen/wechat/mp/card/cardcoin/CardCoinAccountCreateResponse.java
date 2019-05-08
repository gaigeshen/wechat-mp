package me.gaigeshen.wechat.mp.card.cardcoin;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 开通券点账户结果
 *
 * @author gaigeshen
 */
@Getter
public class CardCoinAccountCreateResponse extends AbstractResponse {
  private Integer reward;
}
