package me.gaigeshen.wechat.mp.card.movieticket;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 更新电影票
 *
 * @author gaigeshen
 */
@Builder
public class MovieTicketUpdateRequest implements Request<MovieTicketUpdateResponse> {
  @JSONField(name = "errcode") private String code;
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "ticket_class") private String ticketClass;
  @JSONField(name = "show_time") private long showTime;
  @JSONField(name = "duration") private int duration;
  @JSONField(name = "screening_room") private String screeningRoom;
  @JSONField(name = "seat_number") private String[] seatNumber;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/movieticket/updateuser?access_token=ACCESS_TOKEN";
  }
}
