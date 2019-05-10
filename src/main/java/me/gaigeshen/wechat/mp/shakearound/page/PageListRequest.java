package me.gaigeshen.wechat.mp.shakearound.page;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;

/**
 * 查询页面列表
 *
 * @author gaigeshen
 */
public class PageListRequest implements Request<PageListResponse> {
  private int type;
  @JSONField(name = "page_ids")
  private long[] pageIds;
  private Integer begin;
  private Integer count;

  private PageListRequest(int type, long[] pageIds, Integer begin, Integer count) {
    this.type = type;
    this.pageIds = pageIds;
    this.begin = begin;
    this.count = count;
  }

  public static PageListRequest create(long[] pageIds) {
    return new PageListRequest(1, pageIds, null, null);
  }

  public static PageListRequest create(int begin, int count) {
    return new PageListRequest(2, null, begin, count);
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/page/search?access_token=ACCESS_TOKEN";
  }
}
