package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;

/**
 * 图文消息群发卡券
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class NewsSendallMessageContentRequest implements Request<NewsSendallMessageContentResponse> {
  @JSONField(name = "card_id")
  private String cardId;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/mpnews/gethtml?access_token=ACCESS_TOKEN";
  }
}
