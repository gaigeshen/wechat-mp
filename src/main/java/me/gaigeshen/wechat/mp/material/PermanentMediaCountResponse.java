package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取永久素材总数结果
 *
 * @author gaigeshen
 */
@Getter
public class PermanentMediaCountResponse extends AbstractResponse {
  @JSONField(name = "voice_count") private Integer voiceCount;
  @JSONField(name = "video_count") private Integer videoCount;
  @JSONField(name = "image_count") private Integer imageCount;
  @JSONField(name = "news_count") private Integer newsCount;
}
