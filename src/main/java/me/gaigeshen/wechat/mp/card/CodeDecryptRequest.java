package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;

/**
 * 解码卡券码
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CodeDecryptRequest implements Request<CodeDecryptResponse> {
  @JSONField(name = "encrypt_code")
  private String encryptCode;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/code/decrypt?access_token=ACCESS_TOKEN";
  }
}
