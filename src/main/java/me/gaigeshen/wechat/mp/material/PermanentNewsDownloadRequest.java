package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 永久图文素材下载
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class PermanentNewsDownloadRequest implements Request<PermanentNewsDownloadResponse> {
  @JSONField(name = "media_id")
  private String mediaId;
  @Override
  public Class<PermanentNewsDownloadResponse> responseType() {
    return PermanentNewsDownloadResponse.class;
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
