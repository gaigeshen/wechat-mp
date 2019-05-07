package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 批量查询卡券列表结果
 *
 * @author gaigeshen
 */
@Getter
public class CardListResponse extends AbstractResponse {
  @JSONField(name = "card_id_list")
  private String[] cardIdList;
  @JSONField(name = "total_num")
  private Long totalNum;
}
