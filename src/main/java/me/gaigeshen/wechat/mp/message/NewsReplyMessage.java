package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;

/**
 * @author gaigeshen
 */
@XStreamAlias("xml")
public class NewsReplyMessage extends AbstractReplyMessage {

  @XStreamAlias(("Articles"))
  private Item[] items;

  @XStreamAlias("ArticleCount")
  private int articleCount;

  @XStreamAlias("item")
  @AllArgsConstructor
  public static class Item {
    @XStreamAlias("Title") private String title;
    @XStreamAlias("Description") private String description;
    @XStreamAlias("PicUrl") private String picUrl;
    @XStreamAlias("Url") private String url;
  }

  public NewsReplyMessage(String toUserName, String fromUserName, Item... items) {
    super(toUserName, fromUserName, "news");
    if (items != null) {
      this.items = items;
      this.articleCount = items.length;
    }
  }
}
