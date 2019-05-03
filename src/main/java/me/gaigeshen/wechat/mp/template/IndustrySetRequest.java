package me.gaigeshen.wechat.mp.template;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 设置所属行业
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class IndustrySetRequest implements Request<IndustrySetResponse> {
  @JSONField(name = "industry_id1")
  private String industryId1;
  @JSONField(name = "industry_id2")
  private String industryId2;
  @Override
  public Class<IndustrySetResponse> responseType() {
    return IndustrySetResponse.class;
  }

  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
  }
}
