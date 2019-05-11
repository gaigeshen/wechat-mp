package me.gaigeshen.wechat.mp.shakearound;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 获取设备及用户信息
 *
 * @author gaigeshen
 */
@Builder
public class ShakeAroundInfoRequest implements Request<ShakeAroundInfoResponse> {
  private String ticket;
  @JSONField(name = "need_poi")
  private int needPoi;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/user/getshakeinfo?access_token=ACCESS_TOKEN";
  }
}
