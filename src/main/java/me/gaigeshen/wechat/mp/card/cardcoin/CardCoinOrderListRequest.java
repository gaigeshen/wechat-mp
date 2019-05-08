package me.gaigeshen.wechat.mp.card.cardcoin;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.time.OffsetDateTime;
import java.util.Map;

/**
 * 查询券点的流水详情
 *
 * @author gaigeshen
 */
public class CardCoinOrderListRequest implements Request<CardCoinOrderListResponse> {
  @JSONField(name = "offset") private int offset;
  @JSONField(name = "count") private int count;
  @JSONField(name = "order_type") private String orderType;
  @JSONField(name = "begin_time") private long beginTime;
  @JSONField(name = "end_time") private long endTime;
  @JSONField(name = "nor_filter") private Map<String, Object> norStatus;
  @JSONField(name = "sort_info") private Map<String, Object> sortInfo;

  private CardCoinOrderListRequest(int offset, int count, String orderType,
                                   long beginTime, long endTime,
                                   Map<String, Object> norStatus, Map<String, Object> sortInfo) {
    this.offset = offset;
    this.count = count;
    this.orderType = orderType;
    this.beginTime = beginTime;
    this.endTime = endTime;
    this.norStatus = norStatus;
    this.sortInfo = sortInfo;
  }

  /**
   * 创建查询券点的流水详情请求
   *
   * @param offset 分批查询的起点，从零开始
   * @param count 分批查询的数量
   * @param orderType 所要查询的订单类型，见文档
   * @param beginTime 批量查询订单的起始时间
   * @param endTime 批量查询订单的结束时间
   * @param norStatus 不要拉取的订单状态，见文档
   * @return 查询券点的流水详情请求
   */
  public static CardCoinOrderListRequest create(int offset, int count, String orderType, OffsetDateTime beginTime, OffsetDateTime endTime, String norStatus) {
    return new CardCoinOrderListRequest(offset, count, orderType, beginTime.toEpochSecond(), endTime.toEpochSecond(),
            MapBuilder.builder(1).put("status", norStatus).build(),
            MapBuilder.builder(2)
                    .put("sort_key", "SORT_BY_TIME")
                    .put("sort_type", "SORT_DESC")
                    .build());
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/pay/getorderlist?access_token=ACCESS_TOKEN";
  }
}
