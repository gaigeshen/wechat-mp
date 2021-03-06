package me.gaigeshen.wechat.mp.smart.ocr;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 身份证识别结果
 *
 * @author gaigeshen
 */
@Getter
public class IdCardReadResponse extends AbstractResponse {

  private String type;

  private String id;
  private String name;
  private String addr;

  @JSONField(name = "valid_date") private String validDate;

}
