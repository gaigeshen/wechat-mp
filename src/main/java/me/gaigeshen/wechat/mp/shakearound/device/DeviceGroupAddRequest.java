package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 新增设备分组
 *
 * @author gaigeshen
 */
@Builder
public class DeviceGroupAddRequest implements Request<DeviceGroupAddResponse> {
  @JSONField(name = "group_name")
  private String groupName;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/device/group/add?access_token=ACCESS_TOKEN";
  }
}
