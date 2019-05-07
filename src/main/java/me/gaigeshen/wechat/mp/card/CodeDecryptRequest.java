package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

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
  public Class<CodeDecryptResponse> responseType() {
    return CodeDecryptResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/code/decrypt?access_token=TOKEN";
  }
}
