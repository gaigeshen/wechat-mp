package me.gaigeshen.wechat.mp.message;

/**
 * 抽象消息
 *
 * @author gaigeshen
 */
public abstract class AbstractMessage implements Message {
  private String toUserName;
  private String fromUserName;
  private Long createTime;
  private String msgType;
  private Long msgId;

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
  public Long getMsgId() {
    return msgId;
  }
}
