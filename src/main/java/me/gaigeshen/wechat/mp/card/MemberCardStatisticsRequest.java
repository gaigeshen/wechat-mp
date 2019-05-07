package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 统计会员卡券数据
 *
 * @author gaigeshen
 */
public class MemberCardStatisticsRequest implements Request<MemberCardStatisticsResponse> {
  @JSONField(name = "begin_date") private String beginDate;
  @JSONField(name = "end_date") private String endDate;
  @JSONField(name = "cond_source") private int condSource;

  private MemberCardStatisticsRequest(String beginDate, String endDate, int condSource) {
    this.beginDate = beginDate;
    this.endDate = endDate;
    this.condSource = condSource;
  }

  /**
   * 创建统计会员卡券数据请求
   *
   * @param byApiCreated 是否只查询接口创建的卡券
   * @param beginDate 开始日期
   * @param endDate 结束日期
   * @return 统计会员卡券数据请求
   */
  public static MemberCardStatisticsRequest create(boolean byApiCreated, LocalDate beginDate, LocalDate endDate) {
    return new MemberCardStatisticsRequest(
            beginDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            byApiCreated ? 1: 0);
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/datacube/getcardmembercardinfo?access_token=ACCESS_TOKEN";
  }
}
