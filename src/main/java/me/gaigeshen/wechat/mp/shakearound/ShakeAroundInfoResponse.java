package me.gaigeshen.wechat.mp.shakearound;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取设备及用户信息结果
 *
 * @author gaigeshen
 */
@Getter
public class ShakeAroundInfoResponse extends AbstractResponse {

  private Data data;

  @Getter
  public static class Data {
    @JSONField(name = "page_id")
    private Long pageId;
    @JSONField(name = "openid")
    private String openid;
    @JSONField(name = "poi_id")
    private Long poiId;
    @JSONField(name = "beacon_info")
    private BeaconInfo beaconInfo;
  }
  @Getter
  public static class BeaconInfo {
    private Double distance;
    private Integer major;
    private Integer minor;
    private String uuid;
  }
}
