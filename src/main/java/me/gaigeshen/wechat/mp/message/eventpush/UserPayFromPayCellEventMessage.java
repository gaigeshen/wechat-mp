package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 买单事件
 *
 * @author gaigeshen
 */
public class UserPayFromPayCellEventMessage extends AbstractEventMessage {
  private String cardId;
  private String userCardCode;
  private Long transId;
  private Long locationId;
  private Integer fee;
  private Integer originalFee;

  public String getCardId() {
    return cardId;
  }

  public String getUserCardCode() {
    return userCardCode;
  }

  public Long getTransId() {
    return transId;
  }

  public Long getLocationId() {
    return locationId;
  }

  public Integer getFee() {
    return fee;
  }

  public Integer getOriginalFee() {
    return originalFee;
  }
}
