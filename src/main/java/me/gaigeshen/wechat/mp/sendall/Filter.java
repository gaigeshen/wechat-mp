package me.gaigeshen.wechat.mp.sendall;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;

/**
 * 群发消息过滤条件
 *
 * @author gaigeshen
 */
@Builder
public class Filter {
  @JSONField(name = "is_to_all")
  private boolean isToAll;
  @JSONField(name = "tag_id")
  private String tagId;
}
