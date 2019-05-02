package me.gaigeshen.wechat.mp.sendall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 群发消息结果
 *
 * @author gaigeshen
 */
@Getter
public class MassMessageSendResponse extends AbstractResponse {
  @JSONField(name = "msg_id")
  private Long msgId;
  @JSONField(name = "msg_data_id")
  private Long msgDataId;
}
