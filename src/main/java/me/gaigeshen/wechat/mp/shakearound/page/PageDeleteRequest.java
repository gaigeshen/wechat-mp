package me.gaigeshen.wechat.mp.shakearound.page;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;

/**
 * 页面删除
 *
 * @author gaigeshen
 */
@Builder
public class PageDeleteRequest implements Request<EmptyDataResponse> {
  @JSONField(name = "page_id")
  private long pageId;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/page/delete?access_token=ACCESS_TOKEN";
  }
}
