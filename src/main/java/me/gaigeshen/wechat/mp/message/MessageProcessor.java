package me.gaigeshen.wechat.mp.message;

import java.io.IOException;

/**
 * 消息处理器
 *
 * @author gaigeshen
 */
public interface MessageProcessor extends Comparable<MessageProcessor> {

  @Override
  default int compareTo(MessageProcessor o) {
    return Integer.compare(order(), o.order());
  }

  /**
   * 返回消息的排序数字，消息处理器之间的排序规则以该数字为基准，默认情况越小的排在越前面
   *
   * @return 消息的排序数字
   */
  int order();

  /**
   * 处理消息
   *
   * @param message 消息，有可能是事件消息，如需处理事件消息，请实现接口：{@code EventMessageProcessor}
   * @param response 如果需要响应的话，使用此参数
   * @param processorChain 消息处理器链
   * @throws IOException 处理回复消息的时候发生异常
   * @see me.gaigeshen.wechat.mp.message.eventpush.EventMessageProcessor
   */
  void doProcess(Message message, ReplyMessageResponse response, MessageProcessorChain processorChain)
          throws IOException;

}
