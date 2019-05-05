package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 永久素材列表结果，非图文
 *
 * @author gaigeshen
 */
@Getter
public class PermanentMediaListResponse extends AbstractResponse {
  @JSONField(name = "total_count") private Integer totalCount;
  @JSONField(name = "item_count") private Integer itemCount;
  @JSONField(name = "item") private Item[] items;

  public static class Item {
    @JSONField(name = "media_id") private String mediaId;
    @JSONField(name = "name") private String name;
    @JSONField(name = "update_time") private String updateTime;
    @JSONField(name = "url") private String url;
  }
}
