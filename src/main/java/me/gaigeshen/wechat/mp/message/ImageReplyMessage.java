package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 回复图片消息
 *
 * @author gaigeshen
 */
@XStreamAlias("xml")
@Builder
public class ImageReplyMessage implements ReplyMessage {

  @XStreamAlias(("Image"))
  private Image image;

  @AllArgsConstructor
  public static class Image {
    @XStreamAlias("MediaId") private String mediaId;
  }
}
