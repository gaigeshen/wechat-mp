package me.gaigeshen.wechat.mp.kefu.newapi;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取客服会话列表结果
 *
 * @author gaigeshen
 */
@Getter
public class KefuSessionListResponse extends AbstractResponse {
  @JSONField(name = "sessionlist")
  private Session[] sessions;

  @Getter
  public static class Session {
    @JSONField(name = "createtime") private Long createTime;
    @JSONField(name = "openid") private String openid;
  }
}
