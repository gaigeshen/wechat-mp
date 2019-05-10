package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 申请设备ID
 *
 * @author gaigeshen
 */
@Builder
public class DeviceIdRequest implements Request<DeviceIdResponse> {
  @JSONField(name = "quantity") private int quantity;
  @JSONField(name = "apply_reason") private int applyReason;
  @JSONField(name = "comment") private int comment;
  @JSONField(name = "poi_id") private long poiId;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/device/applyid?access_token=ACCESS_TOKEN";
  }
}
