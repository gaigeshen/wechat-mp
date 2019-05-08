package me.gaigeshen.wechat.mp.card.cardcoin;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 充值券点结果
 *
 * @author gaigeshen
 */
@Getter
public class CardCoinAccountRechargeResponse extends AbstractResponse {
  @JSONField(name = "order_id") private String orderId;
  @JSONField(name = "qrcode_url") private String qrcodeUrl;
  @JSONField(name = "qrcode_buffer") private String qrcodeBuffer;
}
