package me.gaigeshen.wechat.mp.message.eventpush;

/**
 * 群发消息结果事件
 *
 * @author gaigeshen
 */
public class MassMessageResultEventMessage extends AbstractEventMessage {
  private String status;
  private Long totalCount;
  private Long filterCount;
  private Long sentCount;
  private Long errorCount;

  public String getStatus() {
    return status;
  }

  public Long getTotalCount() {
    return totalCount;
  }

  public Long getFilterCount() {
    return filterCount;
  }

  public Long getSentCount() {
    return sentCount;
  }

  public Long getErrorCount() {
    return errorCount;
  }
}
