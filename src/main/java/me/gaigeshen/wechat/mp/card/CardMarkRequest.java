package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 占用卡券
 *
 * @author gaigeshen
 */
@Builder
public class CardMarkRequest implements Request<CardMarkResponse> {
  @JSONField(name = "code") private String code;
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "openid") private String openid;
  @JSONField(name = "is_mark") private boolean isMark;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/code/mark?access_token=ACCESS_TOKEN";
  }
}
