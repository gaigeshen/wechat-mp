package me.gaigeshen.wechat.mp.message;

/**
 * @author gaigeshen
 */
public class VideoMessage extends AbstractMessage {
  private String mediaId;
  private String thumbMediaId;
  private String recognition;

  public String getMediaId() {
    return mediaId;
  }
  public String getThumbMediaId() {
    return thumbMediaId;
  }
  public String getRecognition() {
    return recognition;
  }
}
