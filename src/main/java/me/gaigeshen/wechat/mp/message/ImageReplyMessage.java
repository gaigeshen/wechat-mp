package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;

/**
 * @author gaigeshen
 */
@XStreamAlias("xml")
public class ImageReplyMessage extends AbstractReplyMessage {

  @XStreamAlias(("Image"))
  private Image image;

  @AllArgsConstructor
  public static class Image {
    @XStreamAlias("MediaId") private String mediaId;
  }

  public ImageReplyMessage(String toUserName, String fromUserName, Image image) {
    super(toUserName, fromUserName, "image");
    this.image = image;
  }
}
