package me.gaigeshen.wechat.mp.message.eventpush;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 处理指定类型消息的处理器，提供此抽象类，可以使得用户避免做很多消息类型判断的操作
 *
 * @author gaigeshen
 */
@SuppressWarnings("ALL")
public abstract class TypedEventMessageProcessor<T extends EventMessage> extends EventMessageProcessor {
  @Override
  protected final void doProcess(EventMessage message) {
    doProcessTyped((T) message);
  }

  @Override
  protected final boolean canHandle(EventMessage message) {
    return messageType().equals(message.getClass());
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
      if (((ParameterizedType) superclass).getRawType().equals(TypedEventMessageProcessor.class)) {
        return (ParameterizedType) superclass;
      }
    }
    return typedMessageProcessorType((Class<?>) superclass);
  }

  /**
   * 处理消息
   *
   * @param message 消息
   */
  protected abstract void doProcessTyped(T message);
}
