package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 会员卡激活事件
 *
 * @author gaigeshen
 */
public class MemberCardSubmitUserInfoEventMessage extends AbstractEventMessage {
  private String cardId;
  private String userCardCode;

  public String getCardId() {
    return cardId;
  }
  public String getUserCardCode() {
    return userCardCode;
  }
}
