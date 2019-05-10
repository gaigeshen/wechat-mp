package me.gaigeshen.wechat.mp.shakearound;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.Map;

/**
 * 配置设备与页面的关联关系
 *
 * @author gaigeshen
 */
public class ShakeAroundBindPageToDeviceRequest implements Request<EmptyDataResponse> {
  @JSONField(name = "device_identifier")
  private Map<String, Object> deviceIdentifier;
  @JSONField(name = "page_ids")
  private long[] pageIds;

  private ShakeAroundBindPageToDeviceRequest(Map<String, Object> deviceIdentifier, long[] pageIds) {
    this.deviceIdentifier = deviceIdentifier;
    this.pageIds = pageIds;
  }

  public static ShakeAroundBindPageToDeviceRequest create(Integer deviceId, String uuid, int major, int minor, long[] pageIds) {
    return new ShakeAroundBindPageToDeviceRequest(MapBuilder.builder(4)
            .put("device_id", deviceId)
            .put("uuid", uuid)
            .put("major", major)
            .put("minor", minor)
            .build(), pageIds);
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/device/bindpage?access_token=ACCESS_TOKEN";
  }
}
