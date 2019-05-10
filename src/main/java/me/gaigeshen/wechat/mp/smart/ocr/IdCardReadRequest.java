package me.gaigeshen.wechat.mp.smart.ocr;

import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.UploadItem;

/**
 * 身份证识别
 *
 * @author gaigeshen
 */
@Builder
public class IdCardReadRequest implements Request<IdCardReadResponse> {

  private UploadItem img;

  @Override
  public String requestUri() {
    return "http://api.weixin.qq.com/cv/ocr/idcard?type=photo&access_token=ACCESS_TOCKEN";
  }
}
