package me.gaigeshen.wechat.mp.shakearound;

import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.UploadItem;

/**
 * 上传图片素材
 *
 * @author gaigeshen
 */
@Builder
public class ShakeAroundImageUploadRequest implements Request<ShakeAroundImageUploadResponse> {
  private String type;
  private UploadItem media;

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/material/add?access_token=ACCESS_TOKEN";
  }
}
