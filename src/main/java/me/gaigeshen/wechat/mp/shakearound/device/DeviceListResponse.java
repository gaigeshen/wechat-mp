package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询设备列表结果
 *
 * @author gaigeshen
 */
@Getter
public class DeviceListResponse extends AbstractResponse {

  @JSONField(name = "data")
  private Data data;

  @Getter
  public static class Data {
    @JSONField(name = "devices") private Device[] devices;
    @JSONField(name = "total_count")private Integer totalCount;
  }
  @Getter
  public static class Device {
    @JSONField(name = "comment") private String comment;
    @JSONField(name = "device_id") private Integer deviceId;
    @JSONField(name = "major") private Integer major;
    @JSONField(name = "minor") private Integer minor;
    @JSONField(name = "status") private Integer status;
    @JSONField(name = "last_active_time") private Long lastActiveTime;
    @JSONField(name = "poi_id") private Long poiId;
    @JSONField(name = "uuid") private String uuid;
  }
}
