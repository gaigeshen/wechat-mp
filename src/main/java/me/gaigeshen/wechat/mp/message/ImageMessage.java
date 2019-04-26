package me.gaigeshen.wechat.mp.message;

/**
 * @author gaigeshen
 */
public class ImageMessage extends AbstractMessage {
  private String picUrl;
  private String mediaId;

  public String getPicUrl() {
    return picUrl;
  }
  public String getMediaId() {
    return mediaId;
  }
}
