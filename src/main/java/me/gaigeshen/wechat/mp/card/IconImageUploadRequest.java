package me.gaigeshen.wechat.mp.card;

import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.UploadItem;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 商户图标上传
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class IconImageUploadRequest implements Request<IconImageUploadResponse> {
  private UploadItem buffer;
  @Override
  public Class<IconImageUploadResponse> responseType() {
    return IconImageUploadResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
  }
}
