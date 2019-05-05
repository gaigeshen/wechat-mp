package me.gaigeshen.wechat.mp.material;

import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.UploadItem;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 永久非视频素材上传（非图文素材）
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class PermanentNonVideoUploadRequest implements Request<PermanentUploadResponse> {
  /**
   * <pre>
   * 1. image
   * 2. voice
   * 3. thumb
   * </pre>
   */
  private String type;
  private UploadItem media;
  @Override
  public Class<PermanentUploadResponse> responseType() {
    return PermanentUploadResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN";
  }
}
