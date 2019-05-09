package me.gaigeshen.wechat.mp.store;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 查询门店
 *
 * @author gaigeshen
 */
@Builder
public class StoreRequest implements Request<StoreResponse> {
  @JSONField(name = "poi_id")
  private Long poiId;
  @Override
  public String requestUri() {
    return "http://api.weixin.qq.com/cgi-bin/poi/getpoi?access_token=ACCESS_TOKEN";
  }
}
