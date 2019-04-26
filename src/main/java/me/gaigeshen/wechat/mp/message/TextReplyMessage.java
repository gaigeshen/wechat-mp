package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author gaigeshen
 */
@XStreamAlias("xml")
public class TextReplyMessage extends AbstractReplyMessage {

  @XStreamAlias("Content") private String content;

  public TextReplyMessage(String toUserName, String fromUserName, String content) {
    super(toUserName, fromUserName, "text");
    this.content = content;
  }
}
