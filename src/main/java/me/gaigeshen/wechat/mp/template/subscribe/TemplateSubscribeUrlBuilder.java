package me.gaigeshen.wechat.mp.template.subscribe;

import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * 订阅模板消息授权链接构建器
 *
 * @author gaigeshen
 */
public class TemplateSubscribeUrlBuilder {

  private static final String TEMPLATE_URI = "https://mp.weixin.qq.com/mp/subscribemsg?action=get_confirm&";

  private final String url;

  private TemplateSubscribeUrlBuilder(String url) {
    this.url = url;
  }

  /**
   * 创建订阅模板消息授权链接构建器
   *
   * @param appid 公众号标识
   * @param scene 场景值
   * @param templateId 模板编号
   * @param redirectUrl 重定向地址，将会携带用户标识
   * @param reserved 可不传递该值
   * @return 订阅模板消息授权链接构建器
   */
  public static TemplateSubscribeUrlBuilder create(String appid, String scene, String templateId, String redirectUrl, String reserved) {
    String parameters = URLEncodedUtils.format(Arrays.asList(
            new BasicNameValuePair("appid", appid),
            new BasicNameValuePair("scene", scene),
            new BasicNameValuePair("template_id", templateId),
            new BasicNameValuePair("redirect_url", redirectUrl),
            new BasicNameValuePair("reserved", reserved)),
            Charset.forName("utf-8"));
    return new TemplateSubscribeUrlBuilder(TEMPLATE_URI + parameters + "#wechat_redirect");
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
