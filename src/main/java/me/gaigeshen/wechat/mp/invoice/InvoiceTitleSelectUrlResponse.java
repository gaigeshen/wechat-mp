package me.gaigeshen.wechat.mp.invoice;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取用户抬头专属二维码链接结果
 *
 * @author gaigeshen
 */
@Getter
public class InvoiceTitleSelectUrlResponse extends AbstractResponse {
  private String url;
}
