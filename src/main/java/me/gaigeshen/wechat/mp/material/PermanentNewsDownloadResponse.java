package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 永久图文素材下载结果
 *
 * @author gaigeshen
 */
@Getter
public class PermanentNewsDownloadResponse extends AbstractResponse {
  @JSONField(name = "news_item")
  private News news;
}
