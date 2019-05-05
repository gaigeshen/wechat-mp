package me.gaigeshen.wechat.mp.material;

import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 永久素材列表，非图文
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class PermanentMediaListRequest implements Request<PermanentMediaListResponse> {
  private int offset;
  private int count;

  /**
   * <pre>
   * 1. image
   * 2. video
   * 3. voice
   * </pre>
   */
  private String type;

  @Override
  public Class<PermanentMediaListResponse> responseType() {
    return PermanentMediaListResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
  }
}
