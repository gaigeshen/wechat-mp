package me.gaigeshen.wechat.mp.shakearound.device;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 申请设备ID结果
 *
 * @author gaigeshen
 */
@Getter
public class DeviceIdResponse extends AbstractResponse {

  private Data data;

  @Getter
  public static class Data {
    @JSONField(name = "apply_id") private Long applyId;
    @JSONField(name = "audit_status") private Long auditStatus;
    @JSONField(name = "audit_comment") private String auditComment;
  }
}
