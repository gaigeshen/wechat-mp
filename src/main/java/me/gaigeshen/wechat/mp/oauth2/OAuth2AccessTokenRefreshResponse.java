package me.gaigeshen.wechat.mp.oauth2;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 刷新网页授权访问令牌结果
 *
 * @author gaigeshen
 */
@Getter
public class OAuth2AccessTokenRefreshResponse extends AbstractResponse {
  @JSONField(name = "access_token") private String accessToken;
  @JSONField(name = "expires_in") private Long expiresIn;
  @JSONField(name = "refresh_token") private String refreshToken;
  @JSONField(name = "openid") private String openid;
  @JSONField(name = "scope") private String scope;
}
