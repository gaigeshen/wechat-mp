package me.gaigeshen.wechat.mp.card.cardcoin;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询券点余额结果
 *
 * @author gaigeshen
 */
@Getter
public class CardCoinAccountBalanceResponse extends AbstractResponse {
  @JSONField(name = "free_coin") private Double freeCoin;
  @JSONField(name = "pay_coin") private Double payCoin;
  @JSONField(name = "total_coin") private Double totalCoin;
}
