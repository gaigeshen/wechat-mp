package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询设备分组列表结果
 *
 * @author gaigeshen
 */
@Getter
public class DeviceGroupListResponse extends AbstractResponse {

  private Data data;

  @Getter
  public static class Data {
    @JSONField(name = "total_count")
    private Integer totalCount;
    @JSONField(name = "group_id")
    private Group[] groups;
  }
  @Getter
  public static class Group {
    @JSONField(name = "group_id")
    private Long groupId;
    @JSONField(name = "group_name")
    private String groupName;
  }
}
