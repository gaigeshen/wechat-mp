package me.gaigeshen.wechat.mp.store;

import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 查询门店列表
 *
 * @author gaigeshen
 */
@Builder
public class StoreListRequest implements Request<StoreListResponse> {
  private int begin;
  private int limit;
  @Override
  public String requestUri() {
    return "\thttps://api.weixin.qq.com/cgi-bin/poi/getpoilist?access_token=ACCESS_TOKEN";
  }
}
