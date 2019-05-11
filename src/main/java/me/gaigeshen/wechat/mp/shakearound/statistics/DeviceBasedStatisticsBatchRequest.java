package me.gaigeshen.wechat.mp.shakearound.statistics;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 批量查询设备统计数据
 *
 * @author gaigeshen
 */
@Builder
public class DeviceBasedStatisticsBatchRequest implements Request<DeviceBasedStatisticsBatchResponse> {
  private long date;
  @JSONField(name = "page_index")
  private int pageIndex;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/statistics/devicelist?access_token=ACCESS_TOKEN";
  }
}
