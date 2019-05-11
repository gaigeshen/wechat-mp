package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;

/**
 * 编辑设备分组
 *
 * @author gaigeshen
 */
@Builder
public class DeviceGroupUpdateRequest implements Request<EmptyDataResponse> {
  @JSONField(name = "group_id")
  private long groupId;
  @JSONField(name = "group_name")
  private String groupName;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/device/group/update?access_token=ACCESS_TOKEN";
  }
}
