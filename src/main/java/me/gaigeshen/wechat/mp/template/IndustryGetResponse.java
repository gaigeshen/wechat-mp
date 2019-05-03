package me.gaigeshen.wechat.mp.template;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取所属行业结果
 *
 * @author gaigeshen
 */
@Getter
public class IndustryGetResponse extends AbstractResponse {
  @JSONField(name = "primary_industry")
  private Industry primaryIndustry;
  @JSONField(name = "secondary_industry")
  private Industry secondaryIndustry;

  @Getter
  public static class Industry {
    @JSONField(name = "first_class")
    private String firstClass;
    @JSONField(name = "second_class")
    private String secondClass;
  }
}
