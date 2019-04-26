package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;

/**
 * @author gaigeshen
 */
@XStreamAlias("xml")
public class MusicReplyMessage extends AbstractReplyMessage {

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

  public MusicReplyMessage(String toUserName, String fromUserName, Music music) {
    super(toUserName, fromUserName, "music");
    this.music = music;
  }
}
