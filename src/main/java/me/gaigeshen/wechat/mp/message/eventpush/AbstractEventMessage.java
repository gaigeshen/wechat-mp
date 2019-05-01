package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 抽象事件消息
 *
 * @author gaigeshen
 */
public abstract class AbstractEventMessage implements EventMessage {
  private String toUserName;
  private String fromUserName;
  private Long createTime;
  private String msgType;
  private String event;

  @Override
  public String getToUserName() {
    return toUserName;
  }
  @Override
  public String getFromUserName() {
    return fromUserName;
  }
  @Override
  public Long getCreateTime() {
    return createTime;
  }
  @Override
  public String getMsgType() {
    return msgType;
  }
  @Override
  public String getEvent() {
    return event;
  }
}
