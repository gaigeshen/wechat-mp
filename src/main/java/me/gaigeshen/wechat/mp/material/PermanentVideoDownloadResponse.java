package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 永久视频素材下载结果
 *
 * @author gaigeshen
 */
@Getter
public class PermanentVideoDownloadResponse extends AbstractResponse {
  private String title;
  private String description;
  @JSONField(name = "down_url") private String downloadUrl;
}
