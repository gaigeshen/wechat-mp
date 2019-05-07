package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 用户购买礼品卡付款成功事件
 *
 * @author gaigeshen
 */
public class GiftCardPayDoneEventMessage extends AbstractEventMessage {
  private String pageId;
  private String orderId;

  public String getPageId() {
    return pageId;
  }

  public String getOrderId() {
    return orderId;
  }
}
