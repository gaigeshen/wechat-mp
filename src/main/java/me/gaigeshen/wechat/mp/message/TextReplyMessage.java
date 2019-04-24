package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Builder;

/**
 * 回复文本消息
 *
 * @author gaigeshen
 */
@XStreamAlias("xml")
@Builder
public class TextReplyMessage implements ReplyMessage {
  @XStreamAlias("Content") private String content;
}
