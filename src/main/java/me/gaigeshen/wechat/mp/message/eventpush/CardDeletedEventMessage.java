package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 卡券删除事件
 *
 * @author gaigeshen
 */
public class CardDeletedEventMessage extends AbstractEventMessage {
  private String cardId;
  private String userCardCode;

  public String getCardId() {
    return cardId;
  }
  public String getUserCardCode() {
    return userCardCode;
  }
}
