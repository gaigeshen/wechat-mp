package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;

/**
 * 将消息转发到客服
 *
 * @author gaigeshen
 */
@XStreamAlias("xml")
public class TransferKefuReplyMessage extends AbstractReplyMessage {

  @XStreamAlias(("TransInfo"))
  private TransInfo transInfo;

  @AllArgsConstructor
  public static class TransInfo {
    @XStreamAlias("KfAccount") private String kefuAccount;
  }

  public TransferKefuReplyMessage(String toUserName, String fromUserName, TransInfo transInfo) {
    super(toUserName, fromUserName, "transfer_customer_service");
    this.transInfo = transInfo;
  }
}
