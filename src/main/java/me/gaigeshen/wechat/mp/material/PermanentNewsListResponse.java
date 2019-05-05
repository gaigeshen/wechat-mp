package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 永久图文素材列表结果
 *
 * @author gaigeshen
 */
@Getter
public class PermanentNewsListResponse extends AbstractResponse {
  @JSONField(name = "total_count") private Integer totalCount;
  @JSONField(name = "item_count") private Integer itemCount;
  @JSONField(name = "item") private Item[] items;

  public static class Item {
    @JSONField(name = "media_id") private String mediaId;
    @JSONField(name = "content") private ItemContent content;
    @JSONField(name = "update_time") private String updateTime;
  }

  public static class ItemContent {
    @JSONField(name = "news_item") private News[] items;
  }
}
