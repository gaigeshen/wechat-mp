package me.gaigeshen.wechat.mp.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 长连接转短连接
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class ShortUrlRequest implements Request<ShortUrlResponse> {
  @JSONField(name = "long_url")
  private String longUrl;
  @Override
  public Class<ShortUrlResponse> responseType() {
    return ShortUrlResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN&action=long2short";
  }
}
