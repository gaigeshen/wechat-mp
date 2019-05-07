package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;

/**
 * 删除卡券
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CardDeleteRequest implements Request<CardDeleteResponse> {
  @JSONField(name = "card_id")
  private String cardId;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/delete?access_token=ACCESS_TOKEN";
  }
}
