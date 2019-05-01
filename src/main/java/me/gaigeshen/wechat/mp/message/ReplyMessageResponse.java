package me.gaigeshen.wechat.mp.message;

import java.io.IOException;

/**
 * 回复消息响应
 *
 * @author gaigeshen
 */
public interface ReplyMessageResponse {

  /**
   * 写出回复消息
   *
   * @param message 回复消息
   * @throws IOException 在处理写出回复消息的时候发生异常
   */
  void write(ReplyMessage message) throws IOException;

}
