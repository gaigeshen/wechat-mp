package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 删除永久素材
 *
 * @author gaigeshen
 */
public class PermanentMediaDeleteRequest implements Request<PermanentMediaDeleteResponse> {
  @JSONField(name = "media_id")
  private String mediaId;
  @Override
  public Class<PermanentMediaDeleteResponse> responseType() {
    return PermanentMediaDeleteResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN";
  }
}
