package me.gaigeshen.wechat.mp.smart.ocr;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 银行卡识别结果
 *
 * @author gaigeshen
 */
@Getter
public class BankCardReadResponse extends AbstractResponse {
  private String number;
}
