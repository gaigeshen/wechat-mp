package me.gaigeshen.wechat.mp.message;

/**
 * @author gaigeshen
 */
public interface Message {

  String getToUserName();

  String getFromUserName();

  Long getCreateTime();

  String getMsgType();

  Long getMsgId();

}
