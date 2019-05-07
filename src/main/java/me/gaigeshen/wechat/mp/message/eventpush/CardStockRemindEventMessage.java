package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 库存报警事件
 *
 * @author gaigeshen
 */
public class CardStockRemindEventMessage extends AbstractEventMessage {
  private String cardId;
  private String detail;

  public String getCardId() {
    return cardId;
  }

  public String getDetail() {
    return detail;
  }
}
