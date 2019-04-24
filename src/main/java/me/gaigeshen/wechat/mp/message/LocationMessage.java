package me.gaigeshen.wechat.mp.message;

import lombok.Getter;

/**
 * 地理位置消息
 *
 * @author gaigeshen
 */
@Getter
public class LocationMessage extends AbstractMessage {
  private Double location_X;
  private Double location_Y;
  private Integer scale;
  private String label;
}
