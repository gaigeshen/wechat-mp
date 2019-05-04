package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 临时视频素材获取结果
 *
 * @author gaigeshen
 */
@Getter
public class TempVideoDownloadResponse extends AbstractResponse {
  @JSONField(name = "video_url")
  private String videoUrl; // 只在视频消息素材才存在，其他的都为下载文件的形式
}
