package me.gaigeshen.wechat.mp.accesstoken;

/**
 * 访问令牌缓存
 *
 * @author gaigeshen
 */
public interface AccessTokenCache {

  /**
   * 获取当前有效的访问令牌
   *
   * @return 当前有效的访问令牌
   */
  String currentValidAccessToken();
}
