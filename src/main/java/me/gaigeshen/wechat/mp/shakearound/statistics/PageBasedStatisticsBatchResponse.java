package me.gaigeshen.wechat.mp.shakearound.statistics;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 批量查询页面统计数据结果
 *
 * @author gaigeshen
 */
@Getter
public class PageBasedStatisticsBatchResponse extends AbstractResponse {

  @JSONField(name = "data") private Data data;
  @JSONField(name = "date") private Long date;
  @JSONField(name = "total_count") private Integer totalCount;
  @JSONField(name = "page_index") private Integer pageIndex;

  @Getter
  public static class Data {
    @JSONField(name = "pages") private Page[] pages;
  }

  @Getter
  public static class Page {
    @JSONField(name = "page_id") private Integer pageId;
    @JSONField(name = "click_pv") private Long clickPv;
    @JSONField(name = "click_uv") private Long clickUv;
    @JSONField(name = "shake_pv") private Long shakePv;
    @JSONField(name = "shake_uv") private Long shakeUv;
  }
}
