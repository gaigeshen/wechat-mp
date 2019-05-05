package me.gaigeshen.wechat.mp.user;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取标签列表结果
 *
 * @author gaigeshen
 */
@Getter
public class TagListResponse extends AbstractResponse {

  private Tag[] tags;

  public static class Tag {
    private Long id;
    private String name;
    private Long count; // 此标签下的粉丝数
  }
}
