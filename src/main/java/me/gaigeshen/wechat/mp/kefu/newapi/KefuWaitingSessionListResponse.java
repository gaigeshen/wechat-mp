package me.gaigeshen.wechat.mp.kefu.newapi;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取未接入会话列表结果
 *
 * @author gaigeshen
 */
@Getter
public class KefuWaitingSessionListResponse extends AbstractResponse {
  @JSONField(name = "waitcaselist")
  private Session[] sessions;

  @Getter
  public static class Session {
    @JSONField(name = "latest_time") private Long latestTime;
    @JSONField(name = "openid") private String openid;
  }
}
