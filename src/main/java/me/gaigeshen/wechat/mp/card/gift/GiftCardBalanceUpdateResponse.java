package me.gaigeshen.wechat.mp.card.gift;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 更新用户礼品卡信息结果
 *
 * @author gaigeshen
 */
@Getter
public class GiftCardBalanceUpdateResponse extends AbstractResponse {
  private Integer resultBonus;
  private Integer resultBalance;
  private String openid;
}
