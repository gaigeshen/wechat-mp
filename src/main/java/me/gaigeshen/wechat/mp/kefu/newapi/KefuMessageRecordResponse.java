package me.gaigeshen.wechat.mp.kefu.newapi;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取聊天记录结果
 *
 * @author gaigeshen
 */
@Getter
public class KefuMessageRecordResponse extends AbstractResponse {
  @JSONField(name = "recordlist") private Record[] records;
  @JSONField(name = "number") private Long number;
  @JSONField(name = "msgid") private Long msgId;

  @Getter
  public static class Record {
    @JSONField(name = "openid") private String openid;
    @JSONField(name = "opercode") private Integer opercode;
    @JSONField(name = "text") private String text;
    @JSONField(name = "time") private Long time;
    @JSONField(name = "worker") private String worker;
  }
}
