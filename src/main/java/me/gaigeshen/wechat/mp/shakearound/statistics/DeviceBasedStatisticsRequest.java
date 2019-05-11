package me.gaigeshen.wechat.mp.shakearound.statistics;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.time.LocalDate;
import java.util.Map;

/**
 * 以设备为维度的数据统计
 *
 * @author gaigeshen
 */
public class DeviceBasedStatisticsRequest implements Request<DeviceBasedStatisticsResponse> {

  @JSONField(name = "device_identifier")
  private Map<String, Object> deviceIdentifier;
  @JSONField(name = "begin_date")
  private long beginDate;
  @JSONField(name = "end_date")
  private long endDate;

  private DeviceBasedStatisticsRequest(Map<String, Object> deviceIdentifier, long beginDate, long endDate) {
    this.deviceIdentifier = deviceIdentifier;
    this.beginDate = beginDate;
    this.endDate = endDate;
  }

  public static DeviceBasedStatisticsRequest create(Integer deviceId, String uuid, int major, int minor, LocalDate beginDate, LocalDate endDate) {
    return new DeviceBasedStatisticsRequest(MapBuilder.builder(4)
            .put("device_id", deviceId)
            .put("uuid", uuid)
            .put("major", major)
            .put("minor", minor)
            .build(), beginDate.toEpochDay() * 24 * 3600, endDate.toEpochDay() * 24 * 3600);
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/statistics/device?access_token=ACCESS_TOKEN";
  }
}
