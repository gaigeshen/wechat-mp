package me.gaigeshen.wechat.mp.shakearound.redpack;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 录入红包信息
 *
 * @author gaigeshen
 */
public class RedpackIAddnfoRequest implements Request<RedpackIAddnfoResponse> {
  @JSONField(name = "lottery_id") private String lotteryId;
  @JSONField(name = "mchid") private String mchId;
  @JSONField(name = "sponsor_appid") private String sponsorAppid;
  @JSONField(name = "prize_info_list") private Object[] prizeInfoList;

  private RedpackIAddnfoRequest(String lotteryId, String mchId, String sponsorAppid, Object[] prizeInfoList) {
    if (StringUtils.isAnyBlank(lotteryId, mchId, sponsorAppid)) {
      throw new IllegalArgumentException("Invalid argument");
    }
    this.lotteryId = lotteryId;
    this.mchId = mchId;
    this.sponsorAppid = sponsorAppid;
    this.prizeInfoList = prizeInfoList;
  }

  public static RedpackIAddnfoRequest create(String lotteryId, String mchId, String sponsorAppid, List<String> tickets) {
    List<Map<String, Object>> ticketsMap = new ArrayList<>(tickets.size());
    for (String ticket : tickets) {
      ticketsMap.add(MapBuilder.builder(1).put("ticket", ticket).build());
    }
    return new RedpackIAddnfoRequest(lotteryId, mchId, sponsorAppid, ticketsMap.toArray());
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/lottery/setprizebucket?access_token=ACCESSTOKEN";
  }
}
