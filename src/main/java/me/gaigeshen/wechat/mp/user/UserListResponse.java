package me.gaigeshen.wechat.mp.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取用户列表结果
 *
 * @author gaigeshen
 */
@Getter
public class UserListResponse extends AbstractResponse {
  private Long total;
  private Long count;
  @JSONField(name = "next_openid") private String nextOpenid;
  @JSONField(name = "data") private UserList list;

  public static class UserList {
    @JSONField(name = "openid") private String[] users;
  }
}
