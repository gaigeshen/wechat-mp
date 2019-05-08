package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;

/**
 * 卡券状态查询
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CodeStatusRequest implements Request<CodeStatusResponse> {
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "code") private String code;
  @JSONField(name = "check_consume") private Boolean checkConsume;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/code/get?access_token=ACCESS_TOKEN";
  }
}
