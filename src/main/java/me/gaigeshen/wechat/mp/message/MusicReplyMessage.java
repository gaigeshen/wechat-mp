package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 回复音乐消息
 *
 * @author gaigeshen
 */
@XStreamAlias("xml")
@Builder
public class MusicReplyMessage implements ReplyMessage {

  @XStreamAlias(("Music"))
  private Music music;

  @AllArgsConstructor
  public static class Music {
    @XStreamAlias("Title") private String title;
    @XStreamAlias("Description") private String description;
    @XStreamAlias("MusicUrl") private String musicUrl;
    @XStreamAlias("HQMusicUrl") private String hqMusicUrl;
    @XStreamAlias("ThumbMediaId") private String thumbMediaId;
  }
}
