package me.gaigeshen.wechat.mp.shakearound;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 申请摇一摇功能审核状态查询
 *
 * @author gaigeshen
 */
public class ShakeAroundRegisterStatusRequest implements Request<ShakeAroundRegisterStatusResponse> {
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/account/auditstatus?access_token=ACCESS_TOKEN";
  }
}
