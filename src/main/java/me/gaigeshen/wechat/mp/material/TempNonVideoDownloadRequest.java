package me.gaigeshen.wechat.mp.material;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.ResponseBodyHandler;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import org.apache.commons.lang3.Validate;

/**
 * 临时非视频素材获取
 *
 * @author gaigeshen
 * @see me.gaigeshen.wechat.mp.RequestExecutor#execute(Request, ResponseBodyHandler)
 */
public class TempNonVideoDownloadRequest implements Request<TempNonVideoDownloadResponse> {
  private final String mediaId;
  public TempNonVideoDownloadRequest(String mediaId) {
    Validate.notBlank(mediaId, "mediaId is required");
    this.mediaId = mediaId;
  }
  @Override
  public Class<TempNonVideoDownloadResponse> responseType() {
    return TempNonVideoDownloadResponse.class;
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
