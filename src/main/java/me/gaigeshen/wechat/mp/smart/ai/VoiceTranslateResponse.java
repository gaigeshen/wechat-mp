package me.gaigeshen.wechat.mp.smart.ai;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 语音翻译结果
 *
 * @author gaigeshen
 */
@Getter
public class VoiceTranslateResponse extends AbstractResponse {
  @JSONField(name = "from_content")
  private String fromContent;
  @JSONField(name = "to_content")
  private String toContent;
}
