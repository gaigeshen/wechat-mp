package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 新增设备分组结果
 *
 * @author gaigeshen
 */
@Getter
public class DeviceGroupAddResponse extends AbstractResponse {

  private Data data;

  @Getter
  public static class Data {
    @JSONField(name = "group_id")
    private Long groupId;
    @JSONField(name = "group_name")
    private String groupName;
  }
}
