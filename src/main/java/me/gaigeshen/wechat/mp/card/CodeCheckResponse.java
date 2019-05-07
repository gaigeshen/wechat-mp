package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 核查导入卡券码结果
 *
 * @author gaigeshen
 */
@Getter
public class CodeCheckResponse extends AbstractResponse {
  @JSONField(name = "exist_code")
  private String[] existCode;
  @JSONField(name = "not_exist_code")
  private String[] notExistCode;
}
