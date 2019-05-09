package me.gaigeshen.wechat.mp.store.miniapp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询门店小程序审核结果
 *
 * @author gaigeshen
 */
@Getter
public class StoreMiniappAuditResponse extends AbstractResponse {
  @JSONField(name = "data")
  private Data data;

  @Getter
  public static class Data {
    @JSONField(name = "audit_id") private Long auditId;
    @JSONField(name = "status") private Integer status;
    @JSONField(name = "reason") private String reason;
  }
}
