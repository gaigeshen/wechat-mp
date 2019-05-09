package me.gaigeshen.wechat.mp.store.miniapp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 修改门店小程序信息
 *
 * @author gaigeshen
 */
@Builder
public class StoreMiniappUpdateRequest implements Request<StoreMiniappUpdateResponse> {
  @JSONField(name = "headimg_mediaid")
  private String headimgMediaId;
  @JSONField(name = "intro")
  private String intro;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/wxa/modify_merchant?access_token=ACCESS_TOKEN";
  }
}
