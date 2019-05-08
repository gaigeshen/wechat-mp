package me.gaigeshen.wechat.mp.card.meetingticket;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 会议门票更新
 *
 * @author gaigeshen
 */
@Builder
public class MeetingTicketUpdateRequest implements Request<MeetingTicketUpdateResponse> {
  @JSONField(name = "code") private String code;
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "zone") private String zone;
  @JSONField(name = "entrance") private String entrance;
  @JSONField(name = "seat_number") private String seatNumber;

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/meetingticket/updateuser?access_token=ACCESS_TOKEN";
  }
}
