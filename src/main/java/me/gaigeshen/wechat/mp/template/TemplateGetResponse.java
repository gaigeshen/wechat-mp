package me.gaigeshen.wechat.mp.template;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取模板列表结果
 *
 * @author gaigeshen
 */
@Getter
public class TemplateGetResponse extends AbstractResponse {

  @JSONField(name = "template_list")
  private Template[] templates;

  @Getter
  public static class Template {
    @JSONField(name = "template_id") private String id;
    @JSONField(name = "title") private String title;
    @JSONField(name = "primary_industry") private String primaryIndustry;
    @JSONField(name = "deputy_industry") private String deputyIndustry;
    @JSONField(name = "content") private String content;
    @JSONField(name = "example") private String example;
  }
}
