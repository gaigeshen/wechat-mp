package me.gaigeshen.wechat.mp.card;

import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

import java.util.Map;

/**
 * 创建卡券，由于参数过多，需使用者自己组装请求参数。请求参数类型是映射类型，请按文档说明进行组装正确的格式。
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CardCreateRequest implements Request<CardCreateResponse> {

  private Map<String, Object> card;

  @Override
  public Class<CardCreateResponse> responseType() {
    return CardCreateResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN";
  }
}
