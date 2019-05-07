package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 获取用户已领取卡券
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class UserCardRequest implements Request<UserCardResponse> {
  @JSONField(name = "openid") private String openid;
  @JSONField(name = "card_id") private String cardId;
  @Override
  public Class<UserCardResponse> responseType() {
    return UserCardResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/user/getcardlist?access_token=TOKEN";
  }
}
