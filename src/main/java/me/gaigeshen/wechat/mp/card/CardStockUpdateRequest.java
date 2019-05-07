package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

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
  public Class<CardStockUpdateResponse> responseType() {
    return CardStockUpdateResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/modifystock?access_token=TOKEN";
  }
}
