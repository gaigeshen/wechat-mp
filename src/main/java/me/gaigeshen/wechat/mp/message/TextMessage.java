package me.gaigeshen.wechat.mp.message;

/**
 * 文本消息
 *
 * @author gaigeshen
 */
public class TextMessage extends AbstractMessage {
  private String content;
  private String bizmsgmenuid; // 来自客服消息

  public String getContent() {
    return content;
  }
  public String getBizmsgmenuid() {
    return bizmsgmenuid;
  }
}
