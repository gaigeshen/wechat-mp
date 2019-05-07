package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;

/**
 * 批量查询卡券列表
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CardListRequest implements Request<CardListResponse> {
  private int offset;
  private int count;
  @JSONField(name = "status_list") private String[] statusList;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/batchget?access_token=ACCESS_TOKEN";
  }
}
