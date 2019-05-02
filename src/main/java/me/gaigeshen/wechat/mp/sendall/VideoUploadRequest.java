package me.gaigeshen.wechat.mp.sendall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 上传视频
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class VideoUploadRequest implements Request<VideoUploadResponse> {
  @JSONField(name = "media_id") private String mediaId;
  private String title;
  private String description;
  @Override
  public Class<VideoUploadResponse> responseType() {
    return VideoUploadResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/media/uploadvideo?access_token=ACCESS_TOKEN";
  }
}
