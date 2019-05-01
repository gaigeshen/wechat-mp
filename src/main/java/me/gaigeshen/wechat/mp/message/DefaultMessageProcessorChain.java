package me.gaigeshen.wechat.mp.message;

import org.apache.commons.lang3.Validate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 默认的消息处理器链
 *
 * @author gaigeshen
 */
public class DefaultMessageProcessorChain implements MessageProcessorChain {
  private final List<MessageProcessor> processors;

  /**
   * 创建默认的消息处理器链
   *
   * @param processors 需要处理器集合
   */
  public DefaultMessageProcessorChain(List<MessageProcessor> processors) {
    Validate.notNull(processors, "Processors is required");
    this.processors = processors;
  }

  @Override
  public void doProcess(Message message, ReplyMessageResponse response) throws IOException {
    new ProcessorChainInternal(processors).doProcess(message, response);
  }

  /**
   * @author gaigeshen
   */
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
