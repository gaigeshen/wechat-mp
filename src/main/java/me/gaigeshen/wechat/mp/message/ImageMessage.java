package me.gaigeshen.wechat.mp.message;

import lombok.Getter;

/**
 * 图片消息
 *
 * @author gaigeshen
 */
@Getter
public class ImageMessage extends AbstractMessage {
  private String picUrl;
  private String mediaId;
}
