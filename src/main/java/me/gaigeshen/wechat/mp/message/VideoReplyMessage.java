package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 回复视频消息
 *
 * @author gaigeshen
 */
@XStreamAlias("xml")
@Builder
public class VideoReplyMessage implements ReplyMessage {

  @XStreamAlias(("Video"))
  private Video video;

  @AllArgsConstructor
  public static class Video {
    @XStreamAlias("MediaId") private String mediaId;
    @XStreamAlias("Title") private String title;
    @XStreamAlias("Description") private String description;
  }
}
