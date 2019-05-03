package me.gaigeshen.wechat.mp.oauth2;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * 网页授权链接构建器
 *
 * @author gaigeshen
 */
public class OAuth2AuthorizeUrlBuilder {
  private static final String BASE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?";

  private final String url;

  private OAuth2AuthorizeUrlBuilder(String url) {
    this.url = url;
  }

  /**
   * 创建网页授权链接构建器
   *
   * @param baseScope 是否不需要获取用户信息
   * @param appid 公众号标识
   * @param redirectUri 重定向链接
   * @param state 可不传递，将会原样携带给重定向链接
   * @return 网页授权链接构建器
   */
  public static OAuth2AuthorizeUrlBuilder create(boolean baseScope, String appid, String redirectUri, String state) {
    String parameters = URLEncodedUtils.format(Arrays.asList(
            new BasicNameValuePair("appid", appid),
            new BasicNameValuePair("redirect_uri", redirectUri),
            new BasicNameValuePair("response_type", "code"),
            new BasicNameValuePair("scope", baseScope ? "snsapi_base" : "snsapi_userinfo"),
            new BasicNameValuePair("state", state)),
            Charset.forName("utf-8"));
    return new OAuth2AuthorizeUrlBuilder(BASE_URL + parameters + "#wechat_redirect");
  }

  /**
   * 返回授权链接
   *
   * @return 授权链接
   */
  public String build() {
    return this.url;
  }
}
