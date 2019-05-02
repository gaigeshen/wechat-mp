package me.gaigeshen.wechat.mp.sendall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取群发消息的速度结果
 *
 * @author gaigeshen
 */
@Getter
public class MassMessageSendSpeedGetResponse extends AbstractResponse {
  private Integer speed;
  @JSONField(name = "realspeed")
  private Integer realSpeed;
}
