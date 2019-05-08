package me.gaigeshen.wechat.mp.card.member;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 设置支付后投放会员卡券结果
 *
 * @author gaigeshen
 */
@Getter
public class PayGiftMemberCardAddResponse extends AbstractResponse {

  @JSONField(name = "rule_id") private Long ruleId;
  @JSONField(name = "succ_mchid_list") private String[] succeededMchIdList;
  @JSONField(name = "fail_mchid_list") private FailedMchId[] failedMchIdList;

  public static class FailedMchId {
    @JSONField(name = "mchid") private String mchId;
    @JSONField(name = "errcode") private Integer errorCode;
    @JSONField(name = "errmsg") private String errorMessage;
    @JSONField(name = "occupy_rule_id") private Long occupy_rule_id;
    @JSONField(name = "occupy_appid") private String occupy_appid;
  }
}
