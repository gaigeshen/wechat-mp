package me.gaigeshen.wechat.mp.smart.ocr;

import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.UploadItem;

/**
 * 驾驶证识别
 *
 * @author gaigeshen
 */
@Builder
public class DrivingCardReadRequest implements Request<DrivingCardReadResponse> {
  private UploadItem img;
  @Override
  public String requestUri() {
    return "http://api.weixin.qq.com/cv/ocr/driving?access_token=ACCESS_TOKEN";
  }
}
