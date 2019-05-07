package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 从卡券进入公众号会话事件
 *
 * @author gaigeshen
 */
public class CardUserEnterSessionEventMessage extends AbstractEventMessage {
  private String cardId;
  private String userCardCode;

  public String getCardId() {
    return cardId;
  }

  public String getUserCardCode() {
    return userCardCode;
  }
}
