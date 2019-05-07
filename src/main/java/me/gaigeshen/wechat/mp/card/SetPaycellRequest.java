package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 设置买单
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class SetPaycellRequest implements Request<SetPaycellResponse> {
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "is_open") private boolean isOpen;
  @Override
  public Class<SetPaycellResponse> responseType() {
    return SetPaycellResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/paycell/set?access_token=TOKEN";
  }
}
