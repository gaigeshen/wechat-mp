package me.gaigeshen.wechat.mp.message;

/**
 * @author gaigeshen
 */
public class LinkMessage extends AbstractMessage {
  private String title;
  private String description;
  private String url;

  public String getTitle() {
    return title;
  }
  public String getDescription() {
    return description;
  }
  public String getUrl() {
    return url;
  }
}
