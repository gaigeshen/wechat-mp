package me.gaigeshen.wechat.mp.message;

import java.io.IOException;

/**
 * 消息处理器链
 *
 * @author gaigeshen
 */
public interface MessageProcessorChain {

  /**
   * 处理消息
   *
   * @param message 消息，有可能是事件消息
   * @param response 消息回复的时候需要使用
   * @throws IOException 在处理回复消息的时候发生异常
   */
  void doProcess(Message message, ReplyMessageResponse response) throws IOException;

}
