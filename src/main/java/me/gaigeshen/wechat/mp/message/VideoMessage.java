package me.gaigeshen.wechat.mp.message;

import lombok.Getter;

/**
 * 视频消息
 *
 * @author gaigeshen
 */
@Getter
public class VideoMessage extends AbstractMessage {
  private String mediaId;
  private String thumbMediaId;
}
