package me.gaigeshen.wechat.mp.material;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.UploadItem;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import me.gaigeshen.wechat.mp.commons.JsonUtils;
import me.gaigeshen.wechat.mp.commons.MapBuilder;
import org.apache.commons.lang3.Validate;

/**
 * 永久视频素材上传（非图文素材）
 *
 * @author gaigeshen
 */
public class PermanentVideoUploadRequest implements Request<PermanentUploadResponse> {
  private String description;
  private UploadItem media;

  /**
   * 创建永久视频素材上传请求
   *
   * @param media        视频素材
   * @param title        视频素材的标题
   * @param introduction 视频素材的描述
   */
  public PermanentVideoUploadRequest(UploadItem media, String title, String introduction) {
    Validate.notBlank(title, "title is required");
    Validate.notBlank(introduction, "introduction is required");
    this.media = media;
    this.description = JsonUtils.toJson(MapBuilder.builder(2).put("title", title).put("introduction", introduction).build());
  }

  @Override
  public Class<PermanentUploadResponse> responseType() {
    return PermanentUploadResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=video";
  }
}
