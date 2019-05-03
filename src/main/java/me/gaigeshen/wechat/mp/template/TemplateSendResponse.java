package me.gaigeshen.wechat.mp.template;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 发送模板消息结果
 *
 * @author gaigeshen
 */
@Getter
public class TemplateSendResponse extends AbstractResponse {
  @JSONField(name = "msgid")
  private Long msgId;
}
