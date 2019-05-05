package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 永久素材下载，用于非图文素材，非视频素材的下载，成功的话直接返回文件，请使用请求结果处理器
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class PermanentMediaDownloadRequest implements Request<PermanentMediaDownloadResponse> {
  @JSONField(name = "media_id")
  private String mediaId;
  @Override
  public Class<PermanentMediaDownloadResponse> responseType() {
    return PermanentMediaDownloadResponse.class;
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
