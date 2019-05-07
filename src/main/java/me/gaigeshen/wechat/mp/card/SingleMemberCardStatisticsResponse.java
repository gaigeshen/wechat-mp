package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 统计单张会员卡券数据结果
 *
 * @author gaigeshen
 */
@Getter
public class SingleMemberCardStatisticsResponse extends AbstractResponse {

  @JSONField(name = "list")
  private Data[] dataList;

  public static class Data {
    @JSONField(name = "ref_date") private String date;
    @JSONField(name = "cardid") private String cardId;
    @JSONField(name = "merchanttype") private Long merchantType;
    @JSONField(name = "submerchantid") private Long subMerchantId;
    @JSONField(name = "view_cnt") private Long viewCount;
    @JSONField(name = "view_user") private Long viewUser;
    @JSONField(name = "receive_cnt") private Long receiveCount;
    @JSONField(name = "receive_user") private Long receiveUser;
    @JSONField(name = "verify_cnt") private Long verifyCount;
    @JSONField(name = "verify_user") private Long verifyUser;
    @JSONField(name = "active_cnt") private Long activeCount;
    @JSONField(name = "active_user") private Long activeUser;
    @JSONField(name = "total_user") private Long totalUser;
    @JSONField(name = "new_user") private Long newUser;
    @JSONField(name = "payOriginalFee") private Long payOriginalFee;
    @JSONField(name = "fee") private Long fee;
  }
}
