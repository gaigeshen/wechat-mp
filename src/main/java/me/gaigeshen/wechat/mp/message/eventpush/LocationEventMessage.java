package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 上报地理位置事件
 *
 * @author gaigeshen
 */
public class LocationEventMessage extends AbstractEventMessage {
  private Double latitude;
  private Double longitude;
  private Double precision;

  public Double getLatitude() {
    return latitude;
  }
  public Double getLongitude() {
    return longitude;
  }
  public Double getPrecision() {
    return precision;
  }
}
