package me.gaigeshen.wechat.mp.card.member;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 批量查询支付后投放会员卡券的规则结果
 *
 * @author gaigeshen
 */
@Getter
public class PayGiftMemberCardBatchResponse extends AbstractResponse {

  @JSONField(name = "total_count")
  private Integer totalCount;

  @JSONField(name = "rule_list")
  private RuleInfo[] ruleInfoList;

  public static class RuleInfo {
    @JSONField(name = "type") private String type;
    @JSONField(name = "base_info") private BaseInfo baseInfo;
    @JSONField(name = "member_rule") private MemberRule memberRule;
  }
  public static class BaseInfo {
    @JSONField(name = "mchid_list") private String[] mchIdList;
    @JSONField(name = "begin_time") private Long beginTime;
    @JSONField(name = "end_time") private Long endTime;
    @JSONField(name = "status") private String status;
    @JSONField(name = "create_time") private Long createTime;
    @JSONField(name = "update_time") private Long updateTime;
  }
  public static class MemberRule {
    @JSONField(name = "card_id") private String cardId;
    @JSONField(name = "least_cost") private int leastCost;
    @JSONField(name = "max_cost") private int maxCost;
    @JSONField(name = "jump_url") private String jumpUrl;
    @JSONField(name = "app_brand_id") private String appBrandId;
    @JSONField(name = "app_brand_pass") private String appBrandPass;
  }
}
