package me.gaigeshen.wechat.mp.card.boardingpass;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 更新飞机票
 *
 * @author gaigeshen
 */
@Builder
public class BoardingpassUpdateRequest implements Request<BoardingpassUpdateResponse> {
  @JSONField(name = "code") private String code;
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "passenger_name") private String passengerName;
  @JSONField(name = "level") private String level;
  @JSONField(name = "seat") private String seat;
  @JSONField(name = "etkt_bnr") private String etktBnr;
  @JSONField(name = "qrcode_data") private String qrcodeData;
  @JSONField(name = "is_cancel") private String isCancel;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/boardingpass/checkin?access_token=ACCESS_TOKEN";
  }
}
