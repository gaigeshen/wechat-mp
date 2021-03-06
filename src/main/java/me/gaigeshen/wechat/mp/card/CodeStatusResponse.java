package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 卡券状态查询结果
 *
 * @author gaigeshen
 */
@Getter
public class CodeStatusResponse extends AbstractResponse {

  @JSONField(name = "card") private Card card;
  @JSONField(name = "openid") private String openid;
  @JSONField(name = "can_consume") private Boolean canConsume;
  @JSONField(name = "user_card_status") private String userCardStatus;
  @JSONField(name = "order_id") private String orderId;
  @JSONField(name = "background_pic_url") private String backgroundPicUrl;

  public static class Card {
    @JSONField(name = "card_id") private String cardId;
    @JSONField(name = "begin_time") private Long beginTime;
    @JSONField(name = "end_time") private Long endTime;
    @JSONField(name = "balance") private Integer balance;
    @JSONField(name = "code") private String code;
    @JSONField(name = "card_number") private String cardNumber;

  }
}
