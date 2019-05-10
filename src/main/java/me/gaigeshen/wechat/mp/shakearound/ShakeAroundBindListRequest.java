package me.gaigeshen.wechat.mp.shakearound;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.Map;

/**
 * 查询设备与页面的关联关系
 *
 * @author gaigeshen
 */
public class ShakeAroundBindListRequest implements Request<ShakeAroundBindListResponse> {
  private int type;

  @JSONField(name = "device_identifier")
  private Map<String, Object> deviceIdentifier;

  @JSONField(name = "page_id")
  private Long pageId;
  private Integer begin;
  private Integer count;

  private ShakeAroundBindListRequest(int type, Map<String, Object> deviceIdentifier, Long pageId, Integer begin, Integer count) {
    this.type = type;
    this.deviceIdentifier = deviceIdentifier;
    this.pageId = pageId;
    this.begin = begin;
    this.count = count;
  }

  public static ShakeAroundBindListRequest create(Integer deviceId, String uuid, int major, int minor) {
    return new ShakeAroundBindListRequest(1, MapBuilder.builder(4)
            .put("device_id", deviceId)
            .put("uuid", uuid)
            .put("major", major)
            .put("minor", minor)
            .build(), null, null, null);
  }

  public static ShakeAroundBindListRequest create(long pageId, int begin, int count) {
    return new ShakeAroundBindListRequest(2, null, pageId, begin, count);
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/relation/search?access_token=ACCESS_TOKEN";
  }
}
