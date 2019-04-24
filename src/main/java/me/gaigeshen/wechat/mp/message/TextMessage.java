package me.gaigeshen.wechat.mp.message;

import lombok.Getter;

/**
 * 文本消息
 *
 * @author gaigeshen
 */
@Getter
public class TextMessage extends AbstractMessage {
  private String content;
}
