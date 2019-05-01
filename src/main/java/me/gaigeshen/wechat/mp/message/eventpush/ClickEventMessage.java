package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 点击菜单拉取消息的事件
 *
 * @author gaigeshen
 */
public class ClickEventMessage extends AbstractEventMessage {
  private String eventKey;

  public String getEventKey() {
    return eventKey;
  }
}
