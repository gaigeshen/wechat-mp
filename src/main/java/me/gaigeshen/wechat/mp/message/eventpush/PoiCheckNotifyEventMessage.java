package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 门店审核事件推送
 *
 * @author gaigeshen
 */
public class PoiCheckNotifyEventMessage extends AbstractEventMessage {
  private String uniqId;
  private Long poiId;
  private String result;
  private String msg;

  public String getUniqId() {
    return uniqId;
  }
  public Long getPoiId() {
    return poiId;
  }
  public String getResult() {
    return result;
  }
  public String getMsg() {
    return msg;
  }
}
