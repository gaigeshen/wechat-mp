package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 临时素材上传结果
 *
 * @author gaigeshen
 */
@Getter
public class TempMediaUploadResponse extends AbstractResponse {
  @JSONField(name = "type")
  private String type;
  @JSONField(name = "media_id")
  private String mediaId;
  @JSONField(name = "created_at")
  private Long createdAt;
}
