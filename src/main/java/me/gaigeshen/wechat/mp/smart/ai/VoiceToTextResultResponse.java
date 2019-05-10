package me.gaigeshen.wechat.mp.smart.ai;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * @author gaigeshen
 */
@Getter
public class VoiceToTextResultResponse extends AbstractResponse {
  private String result;
}
