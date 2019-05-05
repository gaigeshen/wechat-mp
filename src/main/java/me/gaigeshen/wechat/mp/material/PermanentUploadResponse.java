package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 永久非图文素材上传结果
 *
 * @author gaigeshen
 */
@Getter
public class PermanentUploadResponse extends AbstractResponse {
  @JSONField(name = "media_id")
  private String mediaId;
  private String url; // 仅新增图片素材时会返回该字段
}
