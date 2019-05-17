package me.gaigeshen.wechat.mp.invoice;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 将用户发票抬头信息录入结果
 *
 * @author gaigeshen
 */
@Getter
public class InvoiceTitleInputResponse extends AbstractResponse {
  private String url;
}
