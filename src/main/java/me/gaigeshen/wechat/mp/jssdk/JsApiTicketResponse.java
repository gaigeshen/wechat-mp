package me.gaigeshen.wechat.mp.jssdk;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 *
 *
 * @author gaigeshen
 */
@Getter
public class JsApiTicketResponse extends AbstractResponse {
  @JSONField(name = "ticket")
  private String ticket;
  @JSONField(name = "expires_in")
  private Long expiresIn;
}
