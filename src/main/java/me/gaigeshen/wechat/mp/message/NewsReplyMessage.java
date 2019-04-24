package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 回复图文消息
 *
 * @author gaigeshen
 */
@XStreamAlias("xml")
@Builder
public class NewsReplyMessage implements ReplyMessage {

  @XStreamAlias(("Articles"))
  private Item[] items;

  @XStreamAlias("item")
  @AllArgsConstructor
  public static class Item {
    @XStreamAlias("Title") private String title;
    @XStreamAlias("Description") private String description;
    @XStreamAlias("PicUrl") private String picUrl;
    @XStreamAlias("Url") private String url;
  }
}
