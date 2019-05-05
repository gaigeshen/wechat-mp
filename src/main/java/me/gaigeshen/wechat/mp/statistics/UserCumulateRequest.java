package me.gaigeshen.wechat.mp.statistics;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 获取用户累计数据
 *
 * @author gaigeshen
 */
public class UserCumulateRequest implements Request<UserCumulateResponse> {
  @JSONField(name = "begin_date")
  private String beginDate;
  @JSONField(name = "end_date")
  private String endDate;

  private UserCumulateRequest(String beginDate, String endDate) {
    this.beginDate = beginDate;
    this.endDate = endDate;
  }

  public static UserCumulateRequest create(LocalDate beginDate, LocalDate endDate) {
    return new UserCumulateRequest(
            beginDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
  }

  @Override
  public Class<UserCumulateResponse> responseType() {
    return UserCumulateResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/datacube/getusercumulate?access_token=ACCESS_TOKEN";
  }
}
