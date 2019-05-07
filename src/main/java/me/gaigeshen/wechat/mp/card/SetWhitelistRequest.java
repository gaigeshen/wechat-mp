package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 设置测试白名单
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class SetWhitelistRequest implements Request<SetWhitelistResponse> {
  @JSONField(name = "openid")
  private String[] openids;
  @JSONField(name = "username")
  private String[] usernames;
  @Override
  public Class<SetWhitelistResponse> responseType() {
    return SetWhitelistResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/testwhitelist/set?access_token=TOKEN";
  }
}
