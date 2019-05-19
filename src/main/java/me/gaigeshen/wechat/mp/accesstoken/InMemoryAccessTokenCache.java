package me.gaigeshen.wechat.mp.accesstoken;

import lombok.extern.slf4j.Slf4j;
import me.gaigeshen.wechat.mp.RequestExecutor;
import org.apache.commons.lang3.Validate;

/**
 * 基于内存的实现的访问令牌缓存
 *
 * @author gaigeshen
 */
@Slf4j
public class InMemoryAccessTokenCache implements AccessTokenCache {

  private final RequestExecutor executor;

  private String accessToken;
  private long accessTokenExpiresAtTimestamp;

  public InMemoryAccessTokenCache(RequestExecutor executor) {
    Validate.notNull(executor, "executor");
    this.executor = executor;
    refreshAccessToken(true);
  }

  @Override
  public String currentValidAccessToken() {
    long currentTimestamp = System.currentTimeMillis();
    if (currentTimestamp >= accessTokenExpiresAtTimestamp) {
      refreshAccessToken(false);
    }
    return accessToken;
  }

  /**
   * 刷新访问令牌
   *
   * @param force 是否强制刷新，在非强制刷新情况下会判断是否过期，如未过期则不会刷新
   */
  private synchronized void refreshAccessToken(boolean force) {
    long currentTimestamp = System.currentTimeMillis();
    if (!force && currentTimestamp < accessTokenExpiresAtTimestamp) {
      return;
    }
    AccessTokenResponse resp = executor.execute(new AccessTokenRequest());
    if (resp.isSucceeded()) {
      accessToken = resp.getAccessToken();
      accessTokenExpiresAtTimestamp = currentTimestamp + (resp.getExpiresIn() * 1000 - 5000);
      log.debug("Access token refresh succeeded");
    } else {
      log.error("Access token refresh failed: {}", resp.getErrorMessage());
      throw new IllegalStateException("Could not refresh access token, because " + resp.getErrorMessage());
    }
  }
}
