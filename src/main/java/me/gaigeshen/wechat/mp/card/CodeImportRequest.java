package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 导入卡券码
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CodeImportRequest implements Request<CodeImportResponse> {
  @JSONField(name = "card_id")
  private String cardId;
  @JSONField(name = "code")
  private String[] codes; // 每次最多一百个
  @Override
  public Class<CodeImportResponse> responseType() {
    return CodeImportResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "http://api.weixin.qq.com/card/code/deposit?access_token=ACCESS_TOKEN";
  }
}
