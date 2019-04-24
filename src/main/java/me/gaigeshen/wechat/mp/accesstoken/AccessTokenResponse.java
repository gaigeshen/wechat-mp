package me.gaigeshen.wechat.mp.accesstoken;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 访问令牌请求结果
 *
 * @author gaigeshen
 */
@Getter
public class AccessTokenResponse extends AbstractResponse {

  @JSONField(name = "access_token")
  private String accessToken;

  @JSONField(name = "expires_in")
  private Integer expiresIn;
}
