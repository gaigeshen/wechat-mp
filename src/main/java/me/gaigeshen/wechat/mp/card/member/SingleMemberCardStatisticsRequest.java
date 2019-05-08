package me.gaigeshen.wechat.mp.card.member;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 统计单张会员卡券数据
 *
 * @author gaigeshen
 */
public class SingleMemberCardStatisticsRequest implements Request<SingleMemberCardStatisticsResponse> {
  @JSONField(name = "begin_date")
  private String beginDate;
  @JSONField(name = "end_date")
  private String endDate;
  @JSONField(name = "card_id")
  private String cardId;

  private SingleMemberCardStatisticsRequest(String beginDate, String endDate, String cardId) {
    this.beginDate = beginDate;
    this.endDate = endDate;
    this.cardId = cardId;
  }

  /**
   * 创建统计会员卡券数据请求
   *
   * @param beginDate    开始日期
   * @param endDate      结束日期
   * @return 统计会员卡券数据请求
   */
  public static SingleMemberCardStatisticsRequest create(LocalDate beginDate, LocalDate endDate, String cardId) {
    return new SingleMemberCardStatisticsRequest(
            beginDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            cardId);
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/datacube/getcardmembercarddetail?access_token=ACCESS_TOKEN";
  }
}
