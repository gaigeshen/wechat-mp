package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 卡券被领取事件
 *
 * @author gaigeshen
 */
public class CardGetByUserEventMessage extends AbstractEventMessage {
  private String cardId;
  private Integer isGiveByFriend;
  private String friendUserName;
  private String userCardCode;
  private String oldUserCardCode;
  private String outerStr;
  private Integer isRestoreMemberCard;
  private Integer isRecommendByFriend;
  private String unionId;

  public String getCardId() {
    return cardId;
  }
  public Integer getIsGiveByFriend() {
    return isGiveByFriend;
  }
  public String getFriendUserName() {
    return friendUserName;
  }
  public String getUserCardCode() {
    return userCardCode;
  }
  public String getOldUserCardCode() {
    return oldUserCardCode;
  }
  public String getOuterStr() {
    return outerStr;
  }
  public Integer getIsRestoreMemberCard() {
    return isRestoreMemberCard;
  }
  public Integer getIsRecommendByFriend() {
    return isRecommendByFriend;
  }
  public String getUnionId() {
    return unionId;
  }
}
