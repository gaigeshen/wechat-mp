package me.gaigeshen.wechat.mp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 网络检测
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class NetworkCheckRequest implements Request<NetworkCheckResponse> {
  private String action;
  @JSONField(name = "check_operator")
  private String checkOperator;

  @Override
  public Class<NetworkCheckResponse> responseType() {
    return NetworkCheckResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/callback/check?access_token=ACCESS_TOKEN";
  }
}
