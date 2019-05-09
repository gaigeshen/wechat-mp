package me.gaigeshen.wechat.mp.message.eventpush;

import me.gaigeshen.wechat.mp.message.NodeName;

/**
 * 创建门店小程序的审核结果
 *
 * @author gaigeshen
 */
public class ApplyMerchantAuditInfoEventMessage extends AbstractEventMessage {
  @NodeName("audit_id") private Long auditId;
  private Integer status;
  private String reason;

  public Long getAuditId() {
    return auditId;
  }
  public Integer getStatus() {
    return status;
  }
  public String getReason() {
    return reason;
  }
}
