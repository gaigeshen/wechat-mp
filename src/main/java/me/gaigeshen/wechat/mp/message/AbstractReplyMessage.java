package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 抽象回复消息
 *
 * @author gaigeshen
 */
public abstract class AbstractReplyMessage implements ReplyMessage {
  @XStreamAlias("ToUserName")   private String toUserName;
  @XStreamAlias("FromUserName") private String fromUserName;
  @XStreamAlias("CreateTime")   private long createTime;
  @XStreamAlias("MsgType")      private String msgType;

  protected AbstractReplyMessage(String toUserName, String fromUserName, String msgType) {
    this.toUserName = toUserName;
    this.fromUserName = fromUserName;
    this.msgType = msgType;
    this.createTime = System.currentTimeMillis() / 1000;
  }

  @Override
  public final String getToUserName() {
    return toUserName;
  }
  @Override
  public String getFromUserName() {
    return fromUserName;
  }
  @Override
  public long getCreateTime() {
    return createTime;
  }
  @Override
  public String getMsgType() {
    return msgType;
  }
}
