package me.gaigeshen.wechat.mp.message;

/**
 * 回复消息，需要回复的时候用到
 *
 * @author gaigeshen
 */
public interface ReplyMessage {
  /**
   * 标识空回复消息
   */
  ReplyMessage BLANK = new ReplyMessage() {
    @Override
    public String getToUserName() { return null; }
    @Override
    public String getFromUserName() { return null; }
    @Override
    public long getCreateTime() { return System.currentTimeMillis() / 1000; }
    @Override
    public String getMsgType() { return null; }
  };

  String getToUserName();
  String getFromUserName();
  long getCreateTime();
  String getMsgType();
}
