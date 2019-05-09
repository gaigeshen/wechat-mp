package me.gaigeshen.wechat.mp.store;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 删除门店
 *
 * @author gaigeshen
 */
@Builder
public class StoreDeleteRequest implements Request<StoreDeleteResponse> {
  @JSONField(name = "poi_id")
  private Long poiId;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/poi/delpoi?access_token=ACCESS_TOKEN";
  }
}
