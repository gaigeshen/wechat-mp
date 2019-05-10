package me.gaigeshen.wechat.mp.shakearound.page;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 新增页面
 *
 * @author gaigeshen
 */
@Builder
public class PageAddRequest implements Request<PageAddResponse> {
  private String title;
  private String description;
  @JSONField(name = "page_url") private String pageUrl;
  private String comment;
  @JSONField(name = "icon_url") private String iconUrl;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/page/add?access_token=ACCESS_TOKEN";
  }
}
