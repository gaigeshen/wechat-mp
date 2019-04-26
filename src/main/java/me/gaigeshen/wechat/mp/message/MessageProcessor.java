package me.gaigeshen.wechat.mp.message;

import java.io.IOException;

/**
 * @author gaigeshen
 */
public interface MessageProcessor extends Comparable<MessageProcessor> {

  @Override
  default int compareTo(MessageProcessor o) {
    return Integer.compare(order(), o.order());
  }

  int order();

  void doProcess(Message message, ReplyMessageResponse response, MessageProcessorChain processorChain)
          throws IOException;

}
