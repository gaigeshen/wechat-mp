package me.gaigeshen.wechat.mp.message;

import lombok.Getter;

/**
 * 链接消息
 *
 * @author gaigeshen
 */
@Getter
public class LinkMessage extends AbstractMessage {
  private String title;
  private String description;
  private String url;
}
