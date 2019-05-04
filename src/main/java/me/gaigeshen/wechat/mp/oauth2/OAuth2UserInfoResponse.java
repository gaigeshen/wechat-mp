package me.gaigeshen.wechat.mp.oauth2;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 网页授权获取用户信息结果
 *
 * @author gaigeshen
 */
@Getter
public class OAuth2UserInfoResponse extends AbstractResponse {
  @JSONField(name = "openid") private String openid;
  @JSONField(name = "nickname") private String nickname;
  @JSONField(name = "sex") private String sex;
  @JSONField(name = "province") private String province;
  @JSONField(name = "city") private String city;
  @JSONField(name = "country") private String country;
  @JSONField(name = "headimgurl") private String avatar;
  @JSONField(name = "privilege") private String[] privilege;
  @JSONField(name = "unionid") private String unionId;
}
