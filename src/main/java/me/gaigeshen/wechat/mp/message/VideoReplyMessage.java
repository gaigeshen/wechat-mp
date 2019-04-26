package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;

/**
 * @author gaigeshen
 */
@XStreamAlias("xml")
public class VideoReplyMessage extends AbstractReplyMessage {
  @XStreamAlias(("Video"))
  private Video video;

  @AllArgsConstructor
  public static class Video {
    @XStreamAlias("MediaId") private String mediaId;
    @XStreamAlias("Title") private String title;
    @XStreamAlias("Description") private String description;
  }

  public VideoReplyMessage(String toUserName, String fromUserName, Video video) {
    super(toUserName, fromUserName, "video");
    this.video = video;
  }
}
