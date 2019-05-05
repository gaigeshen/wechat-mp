package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 永久视频素材下载
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class PermanentVideoDownloadRequest implements Request<PermanentVideoDownloadResponse> {
  @JSONField(name = "media_id")
  private String mediaId;
  @Override
  public Class<PermanentVideoDownloadResponse> responseType() {
    return PermanentVideoDownloadResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
  }
}
