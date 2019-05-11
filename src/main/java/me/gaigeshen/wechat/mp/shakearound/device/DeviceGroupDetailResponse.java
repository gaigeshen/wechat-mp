package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询设备分组详情结果
 *
 * @author gaigeshen
 */
@Getter
public class DeviceGroupDetailResponse extends AbstractResponse {
  @JSONField(name = "data")
  private Data data;

  @Getter
  public static class Data {
    @JSONField(name = "group_id") private Long groupId;
    @JSONField(name = "group_name") private String groupName;
    @JSONField(name = "total_count")private Integer totalCount;
    @JSONField(name = "devices") private Device[] devices;
  }
  @Getter
  public static class Device {
    @JSONField(name = "device_id") private Integer deviceId;
    @JSONField(name = "uuid") private String uuid;
    @JSONField(name = "major") private Integer major;
    @JSONField(name = "minor") private Integer minor;
    @JSONField(name = "comment") private String comment;
    @JSONField(name = "poi_id") private Long poiId;
  }
}
