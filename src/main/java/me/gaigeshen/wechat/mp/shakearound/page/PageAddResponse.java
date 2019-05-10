package me.gaigeshen.wechat.mp.shakearound.page;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * @author gaigeshen
 */
@Getter
public class PageAddResponse extends AbstractResponse {

  private Data data;

  @Getter
  public static class Data {
    @JSONField(name = "page_id")
    private Long pageId;
  }
}
