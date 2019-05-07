package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 进入会员卡事件
 *
 * @author gaigeshen
 */
public class CardViewByUserEventMessage extends AbstractEventMessage {
  private String cardId;
  private String userCardCode;
  private String outerStr;

  public String getCardId() {
    return cardId;
  }

  public String getUserCardCode() {
    return userCardCode;
  }

  public String getOuterStr() {
    return outerStr;
  }
}
