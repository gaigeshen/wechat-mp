package me.gaigeshen.wechat.mp.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 二维码票据创建结果
 *
 * @author gaigeshen
 */
@Getter
public class QRCodeTicketCreateResponse extends AbstractResponse {
  private String ticket; // 获取的二维码票据，在有效时间内换取二维码。
  private String url; // 二维码图片解析后的地址
  @JSONField(name = "expire_seconds") private Integer expireSeconds;
}
