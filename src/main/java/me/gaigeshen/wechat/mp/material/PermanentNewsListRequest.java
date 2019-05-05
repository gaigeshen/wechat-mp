package me.gaigeshen.wechat.mp.material;

import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 永久图文素材列表
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class PermanentNewsListRequest implements Request<PermanentNewsListResponse> {
  private int offset;
  private int count;
  @Override
  public Class<PermanentNewsListResponse> responseType() {
    return PermanentNewsListResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN&type=news";
  }
}
