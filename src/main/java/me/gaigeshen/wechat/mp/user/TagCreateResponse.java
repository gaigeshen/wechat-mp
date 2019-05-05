package me.gaigeshen.wechat.mp.user;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 标签创建结果
 *
 * @author gaigeshen
 */
@Getter
public class TagCreateResponse extends AbstractResponse {

  private Tag tag;

  public static class Tag {
    private Long id;
    private String name;
  }
}
