package me.gaigeshen.wechat.mp.shakearound;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * @author gaigeshen
 */
@Getter
public class ShakeAroundBindListResponse extends AbstractResponse {

  private Data data;

  @Getter
  public static class Data {
    @JSONField(name = "relation") private Relation relation;
    @JSONField(name = "total_count") private Integer totalCount;
  }

  @Getter
  public static class Relation {
    @JSONField(name = "device_id") private Integer deviceId;
    @JSONField(name = "major") private Integer major;
    @JSONField(name = "minor") private Integer minor;
    @JSONField(name = "page_id") private String pageId;
    @JSONField(name = "uuid") private String uuid;
  }
}
