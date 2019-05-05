package me.gaigeshen.wechat.mp.message;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 处理指定类型消息的处理器，提供此抽象类，可以使得用户避免做很多消息类型判断的操作
 *
 * @author gaigeshen
 */
@SuppressWarnings("ALL")
public abstract class TypedMessageProcessor<T extends Message> implements MessageProcessor {

  @Override
  public final void doProcess(Message message, ReplyMessageResponse response, MessageProcessorChain processorChain) throws IOException {
    if (message.getClass().equals(messageType())) {
      // 只处理指定类型的消息
      doProcessTyped((T) message, response, processorChain);
    } else {
      processorChain.doProcess(message, response);
    }
  }

  /**
   * 获取当前处理器所要处理的消息类型
   *
   * @return 消息类型
   */
  private Class<T> messageType() {
    return (Class<T>) typedMessageProcessorType(getClass()).getActualTypeArguments()[0];
  }

  /**
   * 获取指定类型的泛型父类型，而且该泛型父类型必须是处理指定类型消息的处理器
   *
   * @param clazz 指定的类型
   * @return 泛型父类型
   */
  private ParameterizedType typedMessageProcessorType(Class<?> clazz) {
    Type superclass = clazz.getGenericSuperclass();
    if (superclass instanceof ParameterizedType) {
      if (((ParameterizedType) superclass).getRawType().equals(TypedMessageProcessor.class)) {
        return (ParameterizedType) superclass;
      }
    }
    return typedMessageProcessorType((Class<?>) superclass);
  }

  /**
   * 处理消息
   *
   * @param message 消息
   * @param response 需要回复消息时用
   * @param processorChain 消息处理器链
   * @throws IOException 处理回复消息的时候发生异常
   */
  protected abstract void doProcessTyped(T message,
                                         ReplyMessageResponse response,
                                         MessageProcessorChain processorChain) throws IOException;

}
