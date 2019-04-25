package me.gaigeshen.wechat.mp.message.eventpush;

import lombok.Getter;

/**
 * 关注/取消关注事件，有可能是未关注扫描带参数二维码引起的事件
 *
 * @author gaigeshen
 */
@Getter
public class SubscribeEventMessage extends AbstractEventMessage {
  // 如果是在未关注的情况下扫描带参数二维码事件
  // 则会推送关注事件，且带以下两个参数过来
  private String eventKey;
  private String ticket;
}
