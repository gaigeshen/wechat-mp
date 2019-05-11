package me.gaigeshen.wechat.mp.shakearound.device;

import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 查询设备分组列表
 *
 * @author gaigeshen
 */
@Builder
public class DeviceGroupListRequest implements Request<DeviceGroupListResponse> {
  private int begin;
  private int count;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/device/group/getlist?access_token=ACCESS_TOKEN";
  }
}
