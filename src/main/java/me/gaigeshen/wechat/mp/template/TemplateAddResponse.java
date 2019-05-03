package me.gaigeshen.wechat.mp.template;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获得模板结果
 *
 * @author gaigeshen
 */
@Getter
public class TemplateAddResponse extends AbstractResponse {
  @JSONField(name = "template_id")
  private String templateId;
}
