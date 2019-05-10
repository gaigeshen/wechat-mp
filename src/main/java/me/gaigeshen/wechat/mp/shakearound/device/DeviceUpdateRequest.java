package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.Map;

/**
 * 编辑设备信息
 *
 * @author gaigeshen
 */
public class DeviceUpdateRequest implements Request<EmptyDataResponse> {

  @JSONField(name = "device_identifier")
  private Map<String, Object> deviceIdentifier;

  private String comment;

  private DeviceUpdateRequest(Map<String, Object> deviceIdentifier, String comment) {
    this.deviceIdentifier = deviceIdentifier;
    this.comment = comment;
  }

  public static DeviceUpdateRequest create(Integer deviceId, String uuid, int major, int minor, String comment) {
    return new DeviceUpdateRequest(MapBuilder.builder(4)
            .put("device_id", deviceId)
            .put("uuid", uuid)
            .put("major", major)
            .put("minor", minor)
            .build(), comment);
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/device/update?access_token=ACCESS_TOKEN";
  }
}
