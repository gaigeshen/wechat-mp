package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 查询导入卡券码的数量
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CodeCountGetRequest implements Request<CodeCountGetResponse> {
  @JSONField(name = "card_id")
  private String cardId;
  @Override
  public Class<CodeCountGetResponse> responseType() {
    return CodeCountGetResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "http://api.weixin.qq.com/card/code/getdepositcount?access_token=ACCESS_TOKEN";
  }
}
