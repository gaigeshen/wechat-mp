package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 扫描带参数二维码事件，已关注的情况下
 *
 * @author gaigeshen
 */
public class ScanEventMessage extends AbstractEventMessage {
  private String eventKey;
  private String ticket;

  public String getEventKey() {
    return eventKey;
  }
  public String getTicket() {
    return ticket;
  }
}
