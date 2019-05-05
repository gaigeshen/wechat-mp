package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 资质认证成功
 *
 * @author gaigeshen
 */
public class QualificationVerifySuccessEventMessage extends AbstractEventMessage {
  private Long expiredTime;

  public Long getExpiredTime() {
    return expiredTime;
  }
}
