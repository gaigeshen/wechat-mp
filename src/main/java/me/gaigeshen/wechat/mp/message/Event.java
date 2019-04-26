package me.gaigeshen.wechat.mp.message;

/**
 * @author gaigeshen
 */
public interface Event {
  String getToUserName();
  String getFromUserName();
  Long getCreateTime();
  String getEvent();
}
