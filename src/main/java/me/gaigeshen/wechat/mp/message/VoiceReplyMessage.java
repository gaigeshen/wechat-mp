package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;

/**
 * @author gaigeshen
 */
@XStreamAlias("xml")
public class VoiceReplyMessage extends AbstractReplyMessage {

  @XStreamAlias(("Voice"))
  private Voice voice;

  @AllArgsConstructor
  public static class Voice {
    @XStreamAlias("MediaId") private String mediaId;
  }

  public VoiceReplyMessage(String toUserName, String fromUserName, Voice voice) {
    super(toUserName, fromUserName, "voice");
    this.voice = voice;
  }
}
