package me.gaigeshen.wechat.mp.message.eventpush;

import me.gaigeshen.wechat.mp.message.Message;

/**
 * @author gaigeshen
 */
public interface EventMessage extends Message {

  @Override
  default Long getMsgId() { return null; }

  String getEvent();
}
