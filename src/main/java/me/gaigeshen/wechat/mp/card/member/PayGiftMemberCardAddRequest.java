package me.gaigeshen.wechat.mp.card.member;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.time.OffsetDateTime;
import java.util.Map;

/**
 * 设置支付后投放会员卡券
 *
 * @author gaigeshen
 */
public class PayGiftMemberCardAddRequest implements Request<PayGiftMemberCardAddResponse> {

  @JSONField(name = "rule_info")
  private Map<String, Object> ruleInfo;

  private PayGiftMemberCardAddRequest(Map<String, Object> ruleInfo) {
    this.ruleInfo = ruleInfo;
  }

  /**
   * 创建设置支付后投放会员卡券请求
   *
   * @param rule 投放规则
   * @param mchIdList 商户号列表
   * @param beginTime 规则开始时间
   * @param endTime 规则结束时间
   * @return 设置支付后投放会员卡券请求
   */
  public static PayGiftMemberCardAddRequest create(MemberRule rule, String[] mchIdList,
                                                   OffsetDateTime beginTime, OffsetDateTime endTime) {
    return new PayGiftMemberCardAddRequest(MapBuilder.builder(3)
            .put("type", "RULE_TYPE_PAY_MEMBER_CARD")
            .put("base_info", MapBuilder.builder(3)
                    .put("mchid_list", mchIdList)
                    .put("begin_time", beginTime.toEpochSecond())
                    .put("end_time", endTime.toEpochSecond())
                    .build())
            .put("member_rule", rule)
            .build());
  }

  public static MemberRule.MemberRuleBuilder memberRuleBuilder() {
    return MemberRule.builder();
  }

  @Builder
  private static class MemberRule {
    @JSONField(name = "card_id") private String cardId;
    @JSONField(name = "least_cost") private int leastCost;
    @JSONField(name = "max_cost") private int maxCost;
    @JSONField(name = "jump_url") private String jumpUrl;
    @JSONField(name = "app_brand_id") private String appBrandId;
    @JSONField(name = "app_brand_pass") private String appBrandPass;
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/paygiftcard/add?access_token=ACCESS_TOKEN";
  }
}
