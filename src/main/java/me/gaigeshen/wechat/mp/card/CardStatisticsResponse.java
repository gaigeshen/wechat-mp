package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 统计卡券数据结果
 *
 * @author gaigeshen
 */
@Getter
public class CardStatisticsResponse extends AbstractResponse {

  @JSONField(name = "list")
  private Data[] dataList;

  public static class Data {
    @JSONField(name = "ref_date") private String date;
    @JSONField(name = "view_cnt") private Long viewCount;
    @JSONField(name = "view_user") private Long viewUser;
    @JSONField(name = "receive_cnt") private Long receiveCount;
    @JSONField(name = "receive_user") private Long receiveUser;
    @JSONField(name = "verify_cnt") private Long verifyCount;
    @JSONField(name = "verify_user") private Long verifyUser;
    @JSONField(name = "given_cnt") private Long givenCount;
    @JSONField(name = "given_user") private Long givenUser;
    @JSONField(name = "expire_cnt") private Long expireCount;
    @JSONField(name = "expire_user") private Long expireUser;
  }
}
