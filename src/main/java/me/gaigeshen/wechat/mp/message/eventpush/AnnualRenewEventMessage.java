package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 年审通知
 *
 * @author gaigeshen
 */
public class AnnualRenewEventMessage extends AbstractEventMessage {
  private Long expiredTime;

  public Long getExpiredTime() {
    return expiredTime;
  }
}
