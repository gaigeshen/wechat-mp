package me.gaigeshen.wechat.mp.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 设置用户备注
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class RemarkUserRequest implements Request<RemarkUserResponse> {
  @JSONField(name = "openid") private String openid;
  @JSONField(name = "remark") private String remark;
  @Override
  public Class<RemarkUserResponse> responseType() {
    return RemarkUserResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN";
  }
}
