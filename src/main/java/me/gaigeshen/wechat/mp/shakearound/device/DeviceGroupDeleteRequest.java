package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;

/**
 * 删除设备分组
 *
 * @author gaigeshen
 */
@Builder
public class DeviceGroupDeleteRequest implements Request<EmptyDataResponse> {
  @JSONField(name = "group_id")
  private long groupId;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/device/group/delete?access_token=ACCESS_TOKEN";
  }
}
