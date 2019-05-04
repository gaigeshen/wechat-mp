package me.gaigeshen.wechat.mp.material;

import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.UploadItem;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 临时素材上传
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class TempMediaUploadRequest implements Request<TempMediaUploadResponse> {
  /**
   * 素材类型：
   * <pre>
   * 1. image - 图片
   * 2. voice - 语音
   * 3. video - 视频
   * 4. thumb - 缩略图
   * </pre>
   */
  private String type;
  private UploadItem media;

  @Override
  public Class<TempMediaUploadResponse> responseType() {
    return TempMediaUploadResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN";
  }
}
