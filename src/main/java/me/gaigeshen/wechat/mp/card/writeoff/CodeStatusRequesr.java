package me.gaigeshen.wechat.mp.card.writeoff;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 卡券状态查询
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CodeStatusRequesr implements Request<CodeStatusResponse> {
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "code") private String code;
  @JSONField(name = "check_consume") private boolean checkConsume;
  @Override
  public Class<CodeStatusResponse> responseType() {
    return CodeStatusResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/code/get?access_token=TOKEN";
  }
}
