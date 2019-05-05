package me.gaigeshen.wechat.mp.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取黑名单列表
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class BlackListRequest implements Request<BlackListResponse> {
  @JSONField(name = "begin_openid")
  private String beginOpenid; // 为空时，默认从开头拉取。
  @Override
  public Class<BlackListResponse> responseType() {
    return BlackListResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=ACCESS_TOKEN";
  }
}
