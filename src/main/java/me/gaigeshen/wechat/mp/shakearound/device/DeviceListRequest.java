package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.Map;

/**
 * 查询设备列表
 *
 * @author gaigeshen
 */
public class DeviceListRequest implements Request<DeviceListResponse> {

  @JSONField(name = "type")
  private Integer type;

  @JSONField(name = "device_identifier")
  private Map<String, Object> deviceIdentifier;

  @JSONField(name = "last_seen")
  private Integer lastSeen;
  @JSONField(name = "count")
  private Integer count;
  @JSONField(name = "apply_id")
  private Long applyId;

  private DeviceListRequest(Integer type, Map<String, Object> deviceIdentifier, Integer lastSeen, Integer count, Long applyId) {
    this.type = type;
    this.deviceIdentifier = deviceIdentifier;
    this.lastSeen = lastSeen;
    this.count = count;
    this.applyId = applyId;
  }

  public static DeviceListRequest create(Integer deviceId, String uuid, int major, int minor) {
    return new DeviceListRequest(1, MapBuilder.builder(4)
            .put("device_id", deviceId)
            .put("uuid", uuid)
            .put("major", major)
            .put("minor", minor)
            .build(), null, null, null);
  }
  public static DeviceListRequest create(int lastSeen, int count) {
    return new DeviceListRequest(2, null, lastSeen, count, null);
  }
  public static DeviceListRequest create(int lastSeen, int count, long applyId) {
    return new DeviceListRequest(3, null, lastSeen, count, applyId);
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/device/search?access_token=ACCESS_TOKEN";
  }
}
