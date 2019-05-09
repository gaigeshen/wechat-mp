package me.gaigeshen.wechat.mp.store.miniapp;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取门店小程序类目
 *
 * @author gaigeshen
 */
public class StoreMiniappCategoryRequest implements Request<StoreMiniappCategoryResponse> {
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/wxa/get_merchant_category?access_token=ACCESS_TOKEN";
  }
}
