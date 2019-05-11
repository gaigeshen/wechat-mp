package me.gaigeshen.wechat.mp.shakearound.redpack;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 录入红包信息结果
 *
 * @author gaigeshen
 */
@Getter
public class RedpackIAddnfoResponse extends AbstractResponse {

  @JSONField(name = "success_num")
  private Integer successNum;

  @JSONField(name = "repeat_ticket_list") private Ticket[] repeatTicketList;
  @JSONField(name = "expire_ticket_list") private Ticket[] expireTicketList;
  @JSONField(name = "invalid_amount_ticket_list") private Ticket[] invalidAmountTicketList;
  @JSONField(name = "wrong_authmchid_ticket_list") private Ticket[] wrongAuthMchIdTicketList;
  @JSONField(name = "invalid_ticket_list") private Ticket[] invalidTicketList;

  @Getter
  public static class Ticket {
    private String ticket;
  }
}
