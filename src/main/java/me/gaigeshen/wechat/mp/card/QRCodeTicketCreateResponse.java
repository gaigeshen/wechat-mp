package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * @author gaigeshen
 */
@Getter
public class QRCodeTicketCreateResponse extends AbstractResponse {
  @JSONField(name = "ticket") private String ticket;
  @JSONField(name = "url") private String url;
  @JSONField(name = "show_qrcode_url") private String showQrcodeUrl;
  @JSONField(name = "expire_seconds") private Long expireSeconds;
}
