package me.gaigeshen.wechat.mp.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 批量为用户打标签
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class TaggingUserRequest implements Request<TaggingUserResponse> {
  @JSONField(name = "openid_list") private String[] users;
  @JSONField(name = "tagid") private long tagId;
  @Override
  public Class<TaggingUserResponse> responseType() {
    return TaggingUserResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN";
  }
}
