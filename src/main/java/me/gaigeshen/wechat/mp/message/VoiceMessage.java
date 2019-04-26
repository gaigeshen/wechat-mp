package me.gaigeshen.wechat.mp.message;

/**
 * @author gaigeshen
 */
public class VoiceMessage extends AbstractMessage {
  private String mediaId;
  private String format;

  public String getMediaId() {
    return mediaId;
  }
  public String getFormat() {
    return format;
  }
}
