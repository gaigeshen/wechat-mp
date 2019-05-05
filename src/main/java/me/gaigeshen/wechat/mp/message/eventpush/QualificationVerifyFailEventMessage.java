package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 资质认证失败
 *
 * @author gaigeshen
 */
public class QualificationVerifyFailEventMessage extends AbstractEventMessage {
  private Long failTime;
  private String failReason;

  public Long getFailTime() {
    return failTime;
  }

  public String getFailReason() {
    return failReason;
  }
}
