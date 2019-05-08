package me.gaigeshen.wechat.mp.card.ticket;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 卡券票据获取结果
 *
 * @author gaigeshen
 */
@Getter
public class CardTicketResponse extends AbstractResponse {
  @JSONField(name = "ticket")
  private String ticket;
  @JSONField(name = "expires_in")
  private Long expiresIn;
}
