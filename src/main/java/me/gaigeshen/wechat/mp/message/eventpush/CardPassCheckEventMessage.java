package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 卡券审核事件
 *
 * @author gaigeshen
 */
public class CardPassCheckEventMessage extends AbstractEventMessage {
  private String cardId;
  private String refuseReason;

  public String getCardId() {
    return cardId;
  }

  public String getRefuseReason() {
    return refuseReason;
  }
}
