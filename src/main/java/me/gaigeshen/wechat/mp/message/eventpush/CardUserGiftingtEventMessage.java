package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 卡券转赠事件
 *
 * @author gaigeshen
 */
public class CardUserGiftingtEventMessage extends AbstractEventMessage {
  private String cardId;
  private String userCardCode;
  private String isReturnBack;
  private String friendUserName;
  private String isChatRoom;

  public String getCardId() {
    return cardId;
  }
  public String getUserCardCode() {
    return userCardCode;
  }
  public String getIsReturnBack() {
    return isReturnBack;
  }
  public String getFriendUserName() {
    return friendUserName;
  }
  public String getIsChatRoom() {
    return isChatRoom;
  }
}
