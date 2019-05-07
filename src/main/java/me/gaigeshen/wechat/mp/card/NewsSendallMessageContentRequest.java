package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

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
  public Class<NewsSendallMessageContentResponse> responseType() {
    return NewsSendallMessageContentResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/mpnews/gethtml?access_token=TOKEN";
  }
}
