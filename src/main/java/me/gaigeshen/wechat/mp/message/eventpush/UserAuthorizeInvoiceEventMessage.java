package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 开票事件
 *
 * @author gaigeshen
 */
public class UserAuthorizeInvoiceEventMessage extends AbstractEventMessage {
  private String succOrderId;
  private String failOrderId;
  private String appId;
  private String source;

  public String getSuccOrderId() {
    return succOrderId;
  }
  public String getFailOrderId() {
    return failOrderId;
  }
  public String getAppId() {
    return appId;
  }
  public String getSource() {
    return source;
  }
}
