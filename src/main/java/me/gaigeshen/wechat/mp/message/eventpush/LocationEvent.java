package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * @author gaigeshen
 */
public class LocationEvent extends AbstractEvent {
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
