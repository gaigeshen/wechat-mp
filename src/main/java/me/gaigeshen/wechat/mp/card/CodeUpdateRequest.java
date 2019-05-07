package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;

/**
 * 更改卡券码
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CodeUpdateRequest implements Request<CodeUpdateResponse> {
  @JSONField(name = "code")
  private String code;
  @JSONField(name = "card_id")
  private String cardId;
  @JSONField(name = "new_code")
  private String newCode;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/code/update?access_token=TOKEN";
  }
}
