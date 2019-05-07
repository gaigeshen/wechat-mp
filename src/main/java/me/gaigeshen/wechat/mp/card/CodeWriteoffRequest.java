package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;

/**
 * 核销卡券
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CodeWriteoffRequest implements Request<CodeWriteoffResponse> {
  @JSONField(name = "code") private String code;
  @JSONField(name = "card_id") private String cardId;

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/code/consume?access_token=ACCESS_TOKEN";
  }
}
