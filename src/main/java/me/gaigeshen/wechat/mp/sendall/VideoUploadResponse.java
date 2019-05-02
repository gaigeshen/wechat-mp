package me.gaigeshen.wechat.mp.sendall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 上传视频结果
 *
 * @author gaigeshen
 */
@Getter
public class VideoUploadResponse extends AbstractResponse {
  private String type;
  @JSONField(name = "media_id") private String mediaId;
  @JSONField(name = "created_at") private Long createdAt;
}
