package me.gaigeshen.wechat.mp.store;

import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.UploadItem;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 上传新建门店时所使用的图片
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class StoreImageUploadRequest implements Request<StoreImageUploadResponse> {
  private UploadItem buffer;
  @Override
  public Class<StoreImageUploadResponse> responseType() {
    return StoreImageUploadResponse.class;
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
