package me.gaigeshen.wechat.mp.kefu.newapi;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 获取聊天记录
 *
 * @author gaigeshen
 */
@Builder
public class KefuMessageRecordRequest implements Request<KefuMessageRecordResponse> {
  @JSONField(name = "starttime") private long startTime;
  @JSONField(name = "endtime") private long endTime;
  @JSONField(name = "msgid") private long msgId;
  @JSONField(name = "number") private int number;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/customservice/msgrecord/getmsglist?access_token=ACCESS_TOKEN";
  }
}
