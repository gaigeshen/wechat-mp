package me.gaigeshen.wechat.mp;

import org.apache.commons.lang3.Validate;

import java.nio.charset.Charset;

/**
 * 请求结果处理器实现，假定结果内容是字符串内容
 *
 * @author gaigeshen
 */
public abstract class StringResponseBodyHandler implements ResponseBodyHandler {

  private Charset charset;

  public StringResponseBodyHandler() {
    this(Charset.forName("utf-8"));
  }

  public StringResponseBodyHandler(Charset charset) {
    Validate.notNull(charset, "charset is required");
    this.charset = charset;
  }

  @Override
  public void handle(String contentType, byte[] content) {
    handle(contentType, new String(content, charset));
  }


  protected abstract void handle(String contentType, String content);

}
