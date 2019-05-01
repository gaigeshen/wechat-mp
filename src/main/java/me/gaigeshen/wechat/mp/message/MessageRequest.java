package me.gaigeshen.wechat.mp.message;

/**
 * 消息请求
 *
 * @author gaigeshen
 */
public interface MessageRequest {

  /**
   * 返回消息
   *
   * @return 消息，有可能是事件消息
   */
  Message getMessage();

}
