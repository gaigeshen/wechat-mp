package me.gaigeshen.wechat.mp.sendall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 上传图文消息素材结果
 *
 * @author gaigeshen
 */
@Getter
public class NewsUploadResponse extends AbstractResponse {
  private String type;
  @JSONField(name = "media_id")
  private String mediaId;
  @JSONField(name = "created_at")
  private Long createdAt;
}
