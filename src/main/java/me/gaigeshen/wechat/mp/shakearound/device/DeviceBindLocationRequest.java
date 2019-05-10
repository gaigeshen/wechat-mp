package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.Map;

/**
 * 配置门店与设备的关系
 *
 * @author gaigeshen
 */
public class DeviceBindLocationRequest implements Request<EmptyDataResponse> {
  @JSONField(name = "device_identifier")
  private Map<String, Object> deviceIdentifier;

  @JSONField(name = "poi_id")
  private long poiId;
  @JSONField(name = "poi_appid")
  private String poiAppid;
  @JSONField(name = "type")
  private Integer type;

  private DeviceBindLocationRequest(Map<String, Object> deviceIdentifier, long poiId, Integer type, String poiAppid) {
    this.deviceIdentifier = deviceIdentifier;
    this.poiId = poiId;
    this.poiAppid = poiAppid;
    this.type = type;
  }

  public static DeviceBindLocationRequest create(Integer deviceId, String uuid, int major, int minor, long poiId) {
    return new DeviceBindLocationRequest(MapBuilder.builder(4)
            .put("device_id", deviceId)
            .put("uuid", uuid)
            .put("major", major)
            .put("minor", minor)
            .build(), poiId, 1, null);
  }
  public static DeviceBindLocationRequest create(Integer deviceId, String uuid, int major, int minor, long poiId, String poiAppid) {
    return new DeviceBindLocationRequest(MapBuilder.builder(4)
            .put("device_id", deviceId)
            .put("uuid", uuid)
            .put("major", major)
            .put("minor", minor)
            .build(), poiId, 2, poiAppid);
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/device/bindlocation?access_token=ACCESS_TOKEN";
  }
}
