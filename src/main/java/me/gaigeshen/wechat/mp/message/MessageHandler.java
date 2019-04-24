package me.gaigeshen.wechat.mp.message;

/**
 * 消息处理器
 *
 * @author gaigeshen
 */
public interface MessageHandler extends Comparable<MessageHandler> {

  /**
   * 返回排序
   *
   * @return 排序
   */
  int order();

  /**
   * 返回是否需要处理此消息
   *
   * @param message 消息
   * @return 是否需要处理此消息
   */
  boolean canHandle(AbstractMessage message);

  /**
   * 处理消息
   *
   * @param message 消息
   * @return 返回回复消息
   */
  ReplyMessage handle(AbstractMessage message);

  // 默认的比较方式取决于排序值
  @Override
  default int compareTo(MessageHandler o) { return Integer.compare(order(), o.order()); }
}
