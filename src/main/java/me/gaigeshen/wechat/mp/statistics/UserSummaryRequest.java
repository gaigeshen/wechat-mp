package me.gaigeshen.wechat.mp.statistics;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 获取用户增减数据
 *
 * @author gaigeshen
 */
public class UserSummaryRequest implements Request<UserSummaryResponse> {
  @JSONField(name = "begin_date")
  private String beginDate;
  @JSONField(name = "end_date")
  private String endDate;

  private UserSummaryRequest(String beginDate, String endDate) {
    this.beginDate = beginDate;
    this.endDate = endDate;
  }

  public static UserSummaryRequest create(LocalDate beginDate, LocalDate endDate) {
    return new UserSummaryRequest(
            beginDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
  }

  @Override
  public Class<UserSummaryResponse> responseType() {
    return UserSummaryResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/datacube/getusersummary?access_token=ACCESS_TOKEN";
  }
}
