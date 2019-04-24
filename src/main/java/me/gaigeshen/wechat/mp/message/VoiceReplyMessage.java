package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 回复语音消息
 *
 * @author gaigeshen
 */
@XStreamAlias("xml")
@Builder
public class VoiceReplyMessage implements ReplyMessage {

  @XStreamAlias(("Voice"))
  private Voice voice;

  @AllArgsConstructor
  public static class Voice {
    @XStreamAlias("MediaId") private String mediaId;
  }
}
