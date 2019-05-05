package me.gaigeshen.wechat.mp.material;

import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 永久图文素材上传
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class PermanentNewsUploadRequest implements Request<PermanentNewsUploadResponse> {
  private News[] articles;
  @Override
  public Class<PermanentNewsUploadResponse> responseType() {
    return PermanentNewsUploadResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
  }
}
