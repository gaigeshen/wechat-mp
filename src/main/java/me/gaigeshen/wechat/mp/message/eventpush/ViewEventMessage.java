package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 点击菜单跳转链接时的事件
 *
 * @author gaigeshen
 */
public class ViewEventMessage extends AbstractEventMessage {
  private String eventKey;

  public String getEventKey() {
    return eventKey;
  }
}
