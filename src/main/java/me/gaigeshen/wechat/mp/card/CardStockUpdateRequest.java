package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;

/**
 * 修改卡券库存
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CardStockUpdateRequest implements Request<CardStockUpdateResponse> {
  @JSONField(name = "card_id")
  private String cardId;
  @JSONField(name = "increase_stock_value")
  private int increaseStockValue;
  @JSONField(name = "reduce_stock_value")
  private int reduceStockValue;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/modifystock?access_token=ACCESS_TOKEN";
  }
}
