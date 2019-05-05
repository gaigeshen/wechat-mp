package me.gaigeshen.wechat.mp.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取标签下粉丝列表结果
 *
 * @author gaigeshen
 */
@Getter
public class TagUserListResponse extends AbstractResponse {
  @JSONField(name = "count") private Long count;
  @JSONField(name = "data") private TagUser tagUser;
  @JSONField(name = "next_openid") private String nextUser;

  public static class TagUser {
    @JSONField(name = "openid") private String[] users;
  }
}
