package me.gaigeshen.wechat.mp.invoice;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 获取用户抬头专属二维码链接
 *
 * @author gaigeshen
 */
@Builder
public class InvoiceTitleSelectUrlRequest implements Request<InvoiceTitleSelectUrlResponse> {
  @JSONField(name = "attach")
  private String attach;
  @JSONField(name = "biz_name")
  private String bizName;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/invoice/biz/getselecttitleurl?access_token=ACCESS_TOKEN";
  }
}
