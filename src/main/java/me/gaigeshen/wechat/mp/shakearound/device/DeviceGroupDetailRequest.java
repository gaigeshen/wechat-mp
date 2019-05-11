package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 查询设备分组详情
 *
 * @author gaigeshen
 */
@Builder
public class DeviceGroupDetailRequest implements Request<DeviceGroupDetailResponse> {
  @JSONField(name = "group_id")
  private long groupId;
  private int begin;
  private int count;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/device/group/getdetail?access_token=ACCESS_TOKEN";
  }
}
