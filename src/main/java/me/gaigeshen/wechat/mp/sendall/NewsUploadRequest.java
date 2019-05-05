package me.gaigeshen.wechat.mp.sendall;

import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import me.gaigeshen.wechat.mp.material.News;

/**
 * 上传图文消息素材
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class NewsUploadRequest implements Request<NewsUploadResponse> {

  private News[] articles;

  @Override
  public Class<NewsUploadResponse> responseType() {
    return NewsUploadResponse.class;
  }

  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN";
  }
}
