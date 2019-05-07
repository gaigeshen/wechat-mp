package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 用户购买礼品卡后赠送
 *
 * @author gaigeshen
 */
public class GiftCardSendToFriendEventMessage extends AbstractEventMessage {
  private String pageId;
  private String orderId;
  private Boolean isChatRoom;
  private Boolean isReturnBack;

  public String getPageId() {
    return pageId;
  }

  public String getOrderId() {
    return orderId;
  }

  public Boolean getChatRoom() {
    return isChatRoom;
  }

  public Boolean getReturnBack() {
    return isReturnBack;
  }
}
