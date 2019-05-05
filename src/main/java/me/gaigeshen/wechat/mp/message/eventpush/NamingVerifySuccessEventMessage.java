package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 名称认证成功
 *
 * @author gaigeshen
 */
public class NamingVerifySuccessEventMessage extends AbstractEventMessage {
  private Long expiredTime;

  public Long getExpiredTime() {
    return expiredTime;
  }
}
