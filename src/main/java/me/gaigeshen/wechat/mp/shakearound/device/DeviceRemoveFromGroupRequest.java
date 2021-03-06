package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.Map;

/**
 * 移除设备自分组
 *
 * @author gaigeshen
 */
public class DeviceRemoveFromGroupRequest implements Request<EmptyDataResponse> {

  @JSONField(name = "group_id")
  private long groupId;
  @JSONField(name = "device_identifiers")
  private Map<String, Object> device;

  private DeviceRemoveFromGroupRequest(long groupId, Map<String, Object> device) {
    this.groupId = groupId;
    this.device = device;
  }

  public static DeviceRemoveFromGroupRequest create(long groupId, Integer deviceId, String uuid, int major, int minor) {
    return new DeviceRemoveFromGroupRequest(groupId, MapBuilder.builder(4)
            .put("device_id", deviceId)
            .put("uuid", uuid)
            .put("major", major)
            .put("minor", minor)
            .build());
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/device/group/deletedevice?access_token=ACCESS_TOKEN";
  }
}
