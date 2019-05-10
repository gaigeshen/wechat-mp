package me.gaigeshen.wechat.mp.shakearound;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;

/**
 * 申请开通摇一摇周边功能
 *
 * @author gaigeshen
 */
@Builder
public class ShakeAroundRegisterRequest implements Request<EmptyDataResponse> {
  @JSONField(name = "name") private String name;
  @JSONField(name = "phone_number") private String phoneNumber;
  @JSONField(name = "email") private String email;
  @JSONField(name = "industry_id") private String industryId;
  @JSONField(name = "qualification_cert_urls") private String[] qualificationCertUrls;
  @JSONField(name = "apply_reason") private String applyReason;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/account/register?access_token=ACCESS_TOKEN";
  }
}
