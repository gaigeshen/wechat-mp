package me.gaigeshen.wechat.mp.message;

/**
 * @author gaigeshen
 */
public class ScanEvent extends AbstractEvent {
  private String eventKey;
  private String ticket;

  public String getEventKey() {
    return eventKey;
  }
  public String getTicket() {
    return ticket;
  }
}
