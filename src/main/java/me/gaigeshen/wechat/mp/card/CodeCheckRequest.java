package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;

/**
 * 核查导入卡券码
 *
 * @author gaigeshen
 */
public class CodeCheckRequest implements Request<CodeCheckResponse> {
  @JSONField(name = "card_id")
  private String cardId;
  @JSONField(name = "code")
  private String[] codes;
  @Override
  public String requestUri() {
    return "http://api.weixin.qq.com/card/code/checkcode?access_token=ACCESS_TOKEN";
  }
}
