package me.gaigeshen.wechat.mp.shakearound.statistics;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 以页面为维度的数据统计
 *
 * @author gaigeshen
 */
@Builder
public class PageBasedStatisticsRequest implements Request<PageBasedStatisticsResponse> {
  @JSONField(name = "page_id")
  private long pageId;
  @JSONField(name = "begin_date")
  private long beginDate;
  @JSONField(name = "end_date")
  private long endDate;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/statistics/page?access_token=ACCESS_TOKEN";
  }
}
