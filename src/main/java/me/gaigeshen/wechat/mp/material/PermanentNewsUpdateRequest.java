package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * @author gaigeshen
 */
@Getter
@Builder
public class PermanentNewsUpdateRequest implements Request<PermanentNewsUpdateResponse> {
  @JSONField(name = "media_id") private String mediaId;
  @JSONField(name = "index") private int index;
  @JSONField(name = "articles") private News article;
  @Override
  public Class<PermanentNewsUpdateResponse> responseType() {
    return PermanentNewsUpdateResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=ACCESS_TOKEN";
  }
}
