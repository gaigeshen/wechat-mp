package me.gaigeshen.wechat.mp.sendall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 删除群发消息
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class MassMessageDeleteRequest implements Request<MassMessageDeleteResponse> {
  @JSONField(name = "msg_id")
  private long msgId;
  @JSONField(name = "article_idx")
  private int articleIndex;
  @Override
  public Class<MassMessageDeleteResponse> responseType() {
    return MassMessageDeleteResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/message/mass/delete?access_token=ACCESS_TOKEN";
  }
}
