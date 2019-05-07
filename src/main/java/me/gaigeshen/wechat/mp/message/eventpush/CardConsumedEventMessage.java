package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 卡券核销事件
 *
 * @author gaigeshen
 */
public class CardConsumedEventMessage extends AbstractEventMessage {
  private String cardId;
  private String userCardCode;
  private String consumeSource;
  private String locationName;
  private String staffOpenId;
  private String verifyCode;
  private Integer remarkAmount;
  private String outerStr;

  public String getCardId() {
    return cardId;
  }
  public String getUserCardCode() {
    return userCardCode;
  }
  public String getConsumeSource() {
    return consumeSource;
  }
  public String getLocationName() {
    return locationName;
  }
  public String getStaffOpenId() {
    return staffOpenId;
  }
  public String getVerifyCode() {
    return verifyCode;
  }
  public Integer getRemarkAmount() {
    return remarkAmount;
  }
  public String getOuterStr() {
    return outerStr;
  }
}
