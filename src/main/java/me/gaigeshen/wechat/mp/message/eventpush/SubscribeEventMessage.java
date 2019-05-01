package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 关注事件，也有可能是扫描带参二维码事件引起的关注事件
 *
 * @author gaigeshen
 */
public class SubscribeEventMessage extends AbstractEventMessage {
  private String eventKey;
  private String ticket;

  public String getEventKey() {
    return eventKey;
  }
  public String getTicket() {
    return ticket;
  }
}
