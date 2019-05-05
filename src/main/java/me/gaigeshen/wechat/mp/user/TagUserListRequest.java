package me.gaigeshen.wechat.mp.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取标签下粉丝列表
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class TagUserListRequest implements Request<TagUserListResponse> {
  @JSONField(name = "tagid") private long tagId;
  @JSONField(name = "next_openid") private String nextUser;
  @Override
  public Class<TagUserListResponse> responseType() {
    return TagUserListResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=ACCESS_TOKEN";
  }
}
