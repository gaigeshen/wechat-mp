package me.gaigeshen.wechat.mp.message;

/**
 * 消息
 *
 * @author gaigeshen
 */
public interface Message {

  String getToUserName();

  String getFromUserName();

  Long getCreateTime();

  String getMsgType();

  Long getMsgId();

}
