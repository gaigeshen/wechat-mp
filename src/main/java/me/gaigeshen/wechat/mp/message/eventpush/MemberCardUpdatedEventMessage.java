package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 会员卡内容更新事件
 *
 * @author gaigeshen
 */
public class MemberCardUpdatedEventMessage extends AbstractEventMessage {
  private String cardId;
  private String userCardCode;
  private Integer modifyBonus;
  private Integer modifyBalance;

  public String getCardId() {
    return cardId;
  }
  public String getUserCardCode() {
    return userCardCode;
  }
  public Integer getModifyBonus() {
    return modifyBonus;
  }
  public Integer getModifyBalance() {
    return modifyBalance;
  }
}
