package me.gaigeshen.wechat.mp.message.eventpush;

import me.gaigeshen.wechat.mp.message.Message;

/**
 * 事件消息
 *
 * @author gaigeshen
 */
public interface EventMessage extends Message {

  // 但不保证所有的事件消息的编号都为空
  // 群发消息结果通知事件，和模板消息发送结果通知事件就有消息编号
  @Override
  default Long getMsgId() { return null; }

  String getEvent();
}
