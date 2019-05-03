package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 模板消息结果事件
 *
 * @author gaigeshen
 */
public class TemplateResultEventMessage extends AbstractEventMessage {
  private Long msgID;
  private String status;

  @Override
  public Long getMsgId() {
    return msgID;
  }
  public String getStatus() {
    return status;
  }
}
