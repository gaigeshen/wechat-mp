package me.gaigeshen.wechat.mp.message.eventpush;

import me.gaigeshen.wechat.mp.message.Message;

/**
 * 事件消息
 *
 * @author gaigeshen
 */
public interface EventMessage extends Message {

  @Override
  default Long getMsgId() { return null; }

  String getEvent();
}
