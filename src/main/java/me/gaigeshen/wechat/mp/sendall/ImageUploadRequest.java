package me.gaigeshen.wechat.mp.sendall;

import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.UploadItem;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 上传图文消息内的图片
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class ImageUploadRequest implements Request<ImageUploadResponse> {

  private UploadItem media;

  @Override
  public Class<ImageUploadResponse> responseType() {
    return ImageUploadResponse.class;
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
