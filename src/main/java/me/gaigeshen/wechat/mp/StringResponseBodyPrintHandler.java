package me.gaigeshen.wechat.mp;

import java.nio.charset.Charset;

/**
 * 打印请求结果的请求结果处理器
 *
 * @author gaigeshen
 */
public class StringResponseBodyPrintHandler extends StringResponseBodyHandler {
  public StringResponseBodyPrintHandler() {
  }
  public StringResponseBodyPrintHandler(Charset charset) {
    super(charset);
  }

  @Override
  protected void handle(String contentType, String content) {
    System.out.println("Content-Type: " + contentType + ", Content: " + content);
  }
}
