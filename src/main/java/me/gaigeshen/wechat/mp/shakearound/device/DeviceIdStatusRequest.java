package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 查询申请设备ID审核状态
 *
 * @author gaigeshen
 */
@Builder
public class DeviceIdStatusRequest implements Request<DeviceIdStatusResponse> {
  @JSONField(name = "apply_id")
  private Long applyId;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/device/applystatus?access_token=ACCESS_TOKEN";
  }
}
