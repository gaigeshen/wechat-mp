package me.gaigeshen.wechat.mp.message;

import lombok.Getter;

/**
 * 语音消息
 *
 * @author gaigeshen
 */
@Getter
public class VoiceMessage extends AbstractMessage {
  private String mediaId;
  private String format;
  private String recognition;
}
