package me.gaigeshen.wechat.mp.sendall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 查询群发消息状态
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class MassMessageSendStatusRequest implements Request<MassMessageSendStatusResponse> {
  @JSONField(name = "msg_id")
  private long msgId;
  @Override
  public Class<MassMessageSendStatusResponse> responseType() {
    return MassMessageSendStatusResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/message/mass/get?access_token=ACCESS_TOKEN";
  }
}
