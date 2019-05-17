package me.gaigeshen.wechat.mp.message.eventpush;

import me.gaigeshen.wechat.mp.message.NodeName;

/**
 * 接收用户提交的抬头
 *
 * @author gaigeshen
 */
public class InvoiceTitleEventMessage extends AbstractEventMessage {
  @NodeName("title") private String title;
  @NodeName("tax_no") private String taxNo;
  @NodeName("addr") private String addr;
  @NodeName("phone") private String phone;
  @NodeName("bank_type") private String bankType;
  @NodeName("bank_no") private String bankNo;
  @NodeName("attach") private String attach;
  @NodeName("title_type") private String titleType;

  public String getTitle() {
    return title;
  }

  public String getTaxNo() {
    return taxNo;
  }

  public String getAddr() {
    return addr;
  }

  public String getPhone() {
    return phone;
  }

  public String getBankType() {
    return bankType;
  }

  public String getBankNo() {
    return bankNo;
  }

  public String getAttach() {
    return attach;
  }

  public String getTitleType() {
    return titleType;
  }
}
