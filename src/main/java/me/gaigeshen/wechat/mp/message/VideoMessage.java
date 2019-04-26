package me.gaigeshen.wechat.mp.message;

/**
 * @author gaigeshen
 */
public class VideoMessage extends AbstractMessage {
  private String mediaId;
  private String thumbMediaId;

  public String getMediaId() {
    return mediaId;
  }
  public String getThumbMediaId() {
    return thumbMediaId;
  }
}
