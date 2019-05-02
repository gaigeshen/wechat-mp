package me.gaigeshen.wechat.mp.sendall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询群发消息状态结果
 *
 * @author gaigeshen
 */
@Getter
public class MassMessageSendStatusResponse extends AbstractResponse {
  @JSONField(name = "msg_id")
  private Long msgId;
  @JSONField(name = "msg_status")
  private String status;
}
