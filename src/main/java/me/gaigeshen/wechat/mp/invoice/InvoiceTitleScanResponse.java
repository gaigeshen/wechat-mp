package me.gaigeshen.wechat.mp.invoice;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取用户抬头结果，扫描用户的二维码之后
 *
 * @author gaigeshen
 */
@Getter
public class InvoiceTitleScanResponse extends AbstractResponse {
  @JSONField(name = "title_type") private Integer titleType;
  @JSONField(name = "title") private String title;
  @JSONField(name = "phone") private String phone;
  @JSONField(name = "tax_no") private String taxNo;
  @JSONField(name = "addr") private String addr;
  @JSONField(name = "bank_type") private String bankType;
  @JSONField(name = "bank_no") private String bankNo;
}
