package me.gaigeshen.wechat.mp.card.member;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 更新会员信息结果
 *
 * @author gaigeshen
 */
@Getter
public class MemberCardUpdateResponse extends AbstractResponse {
  @JSONField(name = "result_bonus")
  private Integer resultBonus;
  @JSONField(name = "result_balance")
  private Integer resultBalance;
  @JSONField(name = "openid")
  private String openid;
}
