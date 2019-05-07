package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;

/**
 * 设置卡券失效
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CardInvalidateRequest implements Request<CardInvalidateResponse> {
  @JSONField(name = "code")
  private String code;
  @JSONField(name = "card_id")
  private String cardId;
  @JSONField(name = "reason")
  private String reason;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/code/unavailable?access_token=ACCESS_TOKEN";
  }
}
