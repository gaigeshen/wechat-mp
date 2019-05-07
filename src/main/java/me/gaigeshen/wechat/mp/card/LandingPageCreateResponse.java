package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 创建货架结果
 *
 * @author gaigeshen
 */
@Getter
public class LandingPageCreateResponse extends AbstractResponse {
  @JSONField(name = "url")
  private String url;
  @JSONField(name = "page_id")
  private Long pageId;
}
