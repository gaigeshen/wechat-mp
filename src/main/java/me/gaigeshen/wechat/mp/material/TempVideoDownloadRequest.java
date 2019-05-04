package me.gaigeshen.wechat.mp.material;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import org.apache.commons.lang3.Validate;

/**
 * 临时视频素材获取
 *
 * @author gaigeshen
 */
public class TempVideoDownloadRequest implements Request<TempVideoDownloadResponse> {
  private final String mediaId;
  public TempVideoDownloadRequest(String mediaId) {
    Validate.notBlank(mediaId, "mediaId is required");
    this.mediaId = mediaId;
  }
  @Override
  public Class<TempVideoDownloadResponse> responseType() {
    return TempVideoDownloadResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=" + mediaId;
  }
}
