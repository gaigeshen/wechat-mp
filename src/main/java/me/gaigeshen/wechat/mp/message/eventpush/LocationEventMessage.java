package me.gaigeshen.wechat.mp.message.eventpush;

import lombok.Getter;

/**
 * 上报地理位置事件
 *
 * @author gaigeshen
 */
@Getter
public class LocationEventMessage extends AbstractEventMessage {
  private Double latitude;
  private Double longitude;
  private Double precision;
}
