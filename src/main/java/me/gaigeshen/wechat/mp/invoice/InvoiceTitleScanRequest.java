package me.gaigeshen.wechat.mp.invoice;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 获取用户抬头，扫描用户的二维码之后
 *
 * @author gaigeshen
 */
@Builder
public class InvoiceTitleScanRequest implements Request<InvoiceTitleScanResponse> {
  @JSONField(name = "scan_text")
  private String scanText;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/invoice/scantitle?access_token=ACCESS_TOKEN";
  }
}
