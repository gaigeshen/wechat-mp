package me.gaigeshen.wechat.mp.message.eventpush;

import me.gaigeshen.wechat.mp.message.NodeName;

/**
 * 腾讯地图中创建门店的审核结果
 *
 * @author gaigeshen
 */
public class CreateMapPoiAuditInfoEventMessage extends AbstractEventMessage {
  @NodeName("map_poi_id") private String mapPoiId;
  @NodeName("audit_id") private Long auditId;
  @NodeName("status") private Long status;
  @NodeName("name") private String name;
  @NodeName("address") private String address;
  @NodeName("latitude") private Double latitude;
  @NodeName("longitude") private Double longitude;
  @NodeName("sh_remark") private String remark;
}
