package me.gaigeshen.wechat.mp.message.eventpush;

import lombok.Getter;

/**
 * 扫描带参数二维码事件
 *
 * @author gaigeshen
 */
@Getter
public class ScanEventMessage extends AbstractEventMessage {
  private String eventKey;
  private String ticket;
}
