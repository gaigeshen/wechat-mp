package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 券点流水详情事件
 *
 * @author gaigeshen
 */
public class CardPayOrderEventMessage extends AbstractEventMessage {
  private String orderId;
  private String status;
  private Long createOrderTime;
  private Integer payFinishTime;
  private String desc;
  private Integer freeCoinCount;
  private Integer payCoinCount;
  private Integer refundFreeCoinCount;
  private Integer refundPayCoinCount;
  private String orderType;
  private String memo;
  private String receiptInfo;
}
