package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询申请设备ID审核状态结果
 *
 * @author gaigeshen
 */
@Getter
public class DeviceIdStatusResponse extends AbstractResponse {

  private Data data;

  @Getter
  public static class Data {
    @JSONField(name = "apply_time") private Long applyTime;
    @JSONField(name = "audit_comment") private String auditComment;
    @JSONField(name = "audit_status") private Long auditStatus;
    @JSONField(name = "audit_time") private Long auditTime;
  }
}
