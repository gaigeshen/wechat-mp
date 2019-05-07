package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 设置自助核销
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class SetSelfConsumeCellRequest implements Request<SetSelfConsumeCellResponse> {
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "is_open") private boolean isOpen;
  @JSONField(name = "need_verify_cod") private boolean needVerifyCode;
  @JSONField(name = "need_remark_amount") private boolean needRemarkAmount;
  @Override
  public Class<SetSelfConsumeCellResponse> responseType() {
    return SetSelfConsumeCellResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/selfconsumecell/set?access_token=TOKEN";
  }
}
