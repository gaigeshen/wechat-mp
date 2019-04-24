package me.gaigeshen.wechat.mp.message;

import lombok.Getter;

/**
 * 短视频消息
 *
 * @author gaigeshen
 */
@Getter
public class ShortVideoMessage extends AbstractMessage {
  private String mediaId;
  private String thumbMediaId;
}
