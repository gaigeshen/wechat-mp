package me.gaigeshen.wechat.mp.message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gaigeshen
 */
public class DefaultMessageProcessorChain implements MessageProcessorChain {
  private final List<MessageProcessor> processors;

  public DefaultMessageProcessorChain(List<MessageProcessor> processors) {
    this.processors = processors;
  }

  @Override
  public void doProcess(Message message, ReplyMessageResponse response) throws IOException {
    new ProcessorChainInternal(processors).doProcess(message, response);
  }

  private class ProcessorChainInternal implements MessageProcessorChain {
    private final List<? extends MessageProcessor> processors;
    private final int processorsCount;
    private int position;

    ProcessorChainInternal(List<MessageProcessor> processors) {
      List<MessageProcessor> copied = new ArrayList<>(processors);
      copied.add(new MessageProcessor() {
        @Override
        public int order() {
          return Integer.MAX_VALUE;
        }
        @Override
        public void doProcess(Message message, ReplyMessageResponse response, MessageProcessorChain processorChain)
                throws IOException {
          response.write(ReplyMessage.BLANK);
        }
      });
      this.processors = copied;
      this.processorsCount = copied.size();
      this.position = 0;
    }
    @Override
    public void doProcess(Message message, ReplyMessageResponse response) throws IOException {
      if (processorsCount != 0 && position < processorsCount) {
        MessageProcessor next = processors.get(position++);
        next.doProcess(message, response, this);
      }
    }
  }
}
