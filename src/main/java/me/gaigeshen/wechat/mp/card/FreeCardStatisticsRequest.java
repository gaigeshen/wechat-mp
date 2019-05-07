package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 统计免费卡券数据
 *
 * @author gaigeshen
 */
public class FreeCardStatisticsRequest implements Request<FreeCardStatisticsResponse> {
  @JSONField(name = "begin_date") private String beginDate;
  @JSONField(name = "end_date") private String endDate;
  @JSONField(name = "cond_source") private int condSource;
  @JSONField(name = "card_id") private String cardId;

  private FreeCardStatisticsRequest(String beginDate, String endDate, int condSource, String cardId) {
    this.beginDate = beginDate;
    this.endDate = endDate;
    this.condSource = condSource;
    this.cardId = cardId;
  }

  /**
   * 创建统计免费卡券数据请求
   *
   * @param byApiCreated 是否只查询接口创建的卡券
   * @param beginDate 开始日期
   * @param endDate 结束日期
   * @param cardId 卡券编号，可不传递该参数
   * @return 统计免费卡券数据请求
   */
  public static FreeCardStatisticsRequest create(boolean byApiCreated, LocalDate beginDate, LocalDate endDate, String cardId) {
    return new FreeCardStatisticsRequest(
            beginDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            byApiCreated ? 1: 0, cardId);
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/datacube/getcardcardinfo?access_token=ACCESS_TOKEN";
  }
}
