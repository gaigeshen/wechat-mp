package me.gaigeshen.wechat.mp.message.eventpush;
import me.gaigeshen.wechat.mp.message.Message;
import me.gaigeshen.wechat.mp.message.MessageProcessor;
import me.gaigeshen.wechat.mp.message.MessageProcessorChain;
import me.gaigeshen.wechat.mp.message.ReplyMessageResponse;

import java.io.IOException;

/**
 * 事件消息处理器
 *
 * @author gaigeshen
 */
public abstract class EventMessageProcessor implements MessageProcessor {

  @Override
  public void doProcess(Message message, ReplyMessageResponse response, MessageProcessorChain processorChain) throws IOException {
    if (message instanceof EventMessage) {
      doProcess((EventMessage) message); // 事件消息不需要回复
    } else {
      processorChain.doProcess(message, response);
    }
  }

  /**
   * 处理事件消息
   *
   * @param message 事件消息
   */
  protected abstract void doProcess(EventMessage message);

}
