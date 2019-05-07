package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 用户领取礼品卡成功
 *
 * @author gaigeshen
 */
public class GiftCardUserAcceptEventMessage extends AbstractEventMessage {
  private String pageId;
  private String orderId;
  private Boolean isChatRoom;

  public String getPageId() {
    return pageId;
  }

  public String getOrderId() {
    return orderId;
  }

  public Boolean getChatRoom() {
    return isChatRoom;
  }
}
