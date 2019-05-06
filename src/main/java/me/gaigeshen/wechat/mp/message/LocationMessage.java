package me.gaigeshen.wechat.mp.message;

/**
 * @author gaigeshen
 */
public class LocationMessage extends AbstractMessage {
  private Double location_X;
  private Double location_Y;
  private Integer scale;
  private String label;

  public Double getLocation_X() {
    return location_X;
  }
  public Double getLocation_Y() {
    return location_Y;
  }
  public Integer getScale() {
    return scale;
  }
  public String getLabel() {
    return label;
  }
}
