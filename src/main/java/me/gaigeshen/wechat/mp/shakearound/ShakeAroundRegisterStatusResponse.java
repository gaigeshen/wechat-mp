package me.gaigeshen.wechat.mp.shakearound;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 申请摇一摇功能审核状态查询结果
 *
 * @author gaigeshen
 */
@Getter
public class ShakeAroundRegisterStatusResponse extends AbstractResponse {

  private Data data;

  @Getter
  public static class Data {
    @JSONField(name = "apply_time") private Long applyTime;
    @JSONField(name = "audit_comment") private String auditComment;
    @JSONField(name = "audit_status") private Long auditStatus;
    @JSONField(name = "audit_time") private Long auditTime;
  }
}
