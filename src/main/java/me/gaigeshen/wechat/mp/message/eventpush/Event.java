package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * @author gaigeshen
 */
public interface Event {
  String getToUserName();
  String getFromUserName();
  Long getCreateTime();
  String getEvent();
}
