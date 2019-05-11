package me.gaigeshen.wechat.mp.shakearound.redpack;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询红包活动结果
 *
 * @author gaigeshen
 */
@Getter
public class RedpackActivityResponse extends AbstractResponse {

  private Result result;

  @Getter
  public static class Result {
    @JSONField(name = "lottery_id") private String lotteryId;
    @JSONField(name = "title") private String title;
    @JSONField(name = "desc") private String desc;
    @JSONField(name = "onoff") private Integer onoff;
    @JSONField(name = "begin_time") private Long beginTime;
    @JSONField(name = "expire_time") private Long expireTime;
    @JSONField(name = "sponsor_appid") private String sponsorAppid;
    @JSONField(name = "appid") private String appid;
    @JSONField(name = "prize_count_limit") private Long prizeCountLimit;
    @JSONField(name = "prize_count") private Long prizeCount;
    @JSONField(name = "jump_url") private String jumpUrl;
    @JSONField(name = "expired_prizes") private Long expiredPrizes;
    @JSONField(name = "available_prizes") private Long availablePrizes;
    @JSONField(name = "expired_value") private Long expiredValue;
    @JSONField(name = "drawed_value") private Long drawedValue;
    @JSONField(name = "available_value") private Long availableValue;
  }
}
