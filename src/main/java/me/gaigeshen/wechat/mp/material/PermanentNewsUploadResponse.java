package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 永久图文素材上传结果
 *
 * @author gaigeshen
 */
@Getter
public class PermanentNewsUploadResponse extends AbstractResponse {
  @JSONField(name = "media_id")
  private String mediaId;
}
