package me.gaigeshen.wechat.mp.smart.ocr;

import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.UploadItem;

/**
 * 银行卡识别
 *
 * @author gaigeshen
 */
@Builder
public class BankCardReadRequest implements Request<BankCardReadResponse> {

  private UploadItem img;

  @Override
  public String requestUri() {
    return "http://api.weixin.qq.com/cv/ocr/bankcard?access_token=ACCESS_TOCKEN";
  }
}
