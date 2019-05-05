package me.gaigeshen.wechat.mp.account;

import org.apache.commons.lang3.Validate;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.Collections;

/**
 * 二维码图片链接构建器
 *
 * @author gaigeshen
 */
public class QRCodeImageUrlBuilder {

  private static final String BASE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?";

  private final String ticket;

  private QRCodeImageUrlBuilder(String ticket) {
    Validate.notBlank(ticket, "ticket is required");
    this.ticket = ticket;
  }

  /**
   * 创建二维码图片链接构建器
   *
   * @param ticket 二维码票据
   * @return 二维码图片链接构建器
   */
  public static QRCodeImageUrlBuilder create(String ticket) {
    return new QRCodeImageUrlBuilder(ticket);
  }

  /**
   * 返回二维码图片链接
   *
   * @return 二维码图片链接
   */
  public String build() {
    return BASE_URL +  URLEncodedUtils.format(
            Collections.singletonList(new BasicNameValuePair("ticket", ticket)), "utf-8");
  }
}
