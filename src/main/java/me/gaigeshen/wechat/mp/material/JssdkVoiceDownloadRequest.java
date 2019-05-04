package me.gaigeshen.wechat.mp.material;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import org.apache.commons.lang3.Validate;

/**
 * 高清语音素材获取
 *
 * @author gaigeshen
 */
public class JssdkVoiceDownloadRequest implements Request<JssdkVoiceDownloadResponse> {
  private final String mediaId;
  public JssdkVoiceDownloadRequest(String mediaId) {
    Validate.notBlank(mediaId, "mediaId is required");
    this.mediaId = mediaId;
  }
  @Override
  public Class<JssdkVoiceDownloadResponse> responseType() {
    return JssdkVoiceDownloadResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/media/get/jssdk?access_token=ACCESS_TOKEN&media_id=" + mediaId;
  }
}
