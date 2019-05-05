package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 认证过期失效通知
 *
 * @author gaigeshen
 */
public class VerifyExpiredEventMessage extends AbstractEventMessage {
  private Long expiredTime;

  public Long getExpiredTime() {
    return expiredTime;
  }
}
