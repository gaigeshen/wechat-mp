package me.gaigeshen.wechat.mp.message.eventpush;

import lombok.Getter;

/**
 * 自定义菜单事件
 *
 * @author gaigeshen
 */
@Getter
public class ClickEventMessage extends AbstractEventMessage {
  private String eventKey;
}
