package me.gaigeshen.wechat.mp.store;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 门店类目表
 *
 * @author gaigeshen
 */
public class StoreCategoryRequest implements Request<StoreCategoryResponse> {
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "http://api.weixin.qq.com/cgi-bin/poi/getwxcategory?access_token=ACCESS_TOKEN";
  }
}
