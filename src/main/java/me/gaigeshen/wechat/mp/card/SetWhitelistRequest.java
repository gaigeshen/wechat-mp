package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;

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
  public String requestUri() {
    return "https://api.weixin.qq.com/card/testwhitelist/set?access_token=ACCESS_TOKEN";
  }
}
