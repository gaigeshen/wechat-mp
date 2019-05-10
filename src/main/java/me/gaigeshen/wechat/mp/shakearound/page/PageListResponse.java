package me.gaigeshen.wechat.mp.shakearound.page;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询页面列表结果
 *
 * @author gaigeshen
 */
@Getter
public class PageListResponse extends AbstractResponse {

  private Data data;

  @Getter
  public static class Data {
    private Page[] pages;
    @JSONField(name = "total_count") private Integer totalCount;
  }

  @Getter
  public static class Page {
    @JSONField(name = "page_id") private long pageId;
    private String title;
    private String description;
    @JSONField(name = "page_url") private String pageUrl;
    private String comment;
    @JSONField(name = "icon_url") private String iconUrl;
  }
}
