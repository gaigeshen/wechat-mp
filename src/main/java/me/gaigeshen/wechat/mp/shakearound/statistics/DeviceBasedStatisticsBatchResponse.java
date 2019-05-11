package me.gaigeshen.wechat.mp.shakearound.statistics;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 批量查询设备统计数据结果
 *
 * @author gaigeshen
 */
@Getter
public class DeviceBasedStatisticsBatchResponse extends AbstractResponse {

  @JSONField(name = "data") private Data data;
  @JSONField(name = "date") private Long date;
  @JSONField(name = "total_count") private Integer totalCount;
  @JSONField(name = "page_index") private Integer pageIndex;

  @Getter
  public static class Data {
    @JSONField(name = "devices") private Device[] devices;
  }

  @Getter
  public static class Device {
    @JSONField(name = "device_id") private Integer deviceId;
    @JSONField(name = "major") private Integer major;
    @JSONField(name = "minor") private Integer minor;
    @JSONField(name = "uuid") private String uuid;
    @JSONField(name = "click_pv") private Long clickPv;
    @JSONField(name = "click_uv") private Long clickUv;
    @JSONField(name = "shake_pv") private Long shakePv;
    @JSONField(name = "shake_uv") private Long shakeUv;
  }
}
