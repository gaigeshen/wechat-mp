package me.gaigeshen.wechat.mp.store.miniapp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 创建门店小程序
 *
 * @author gaigeshen
 */
@Builder
public class StoreMiniappCreateRequest implements Request<StoreMiniappCreateResponse> {
  @JSONField(name = "first_catid") private long firstCategoryId;
  @JSONField(name = "second_catid") private long secondCategoryId;
  @JSONField(name = "qualification_list") private String[] qualificationList;
  @JSONField(name = "headimg_mediaid") private String headimgMediaId;
  @JSONField(name = "nickname") private String nickname;
  @JSONField(name = "intro") private String intro;
  @JSONField(name = "org_code") private String orgCode;
  @JSONField(name = "other_files") private String[] otherFiles;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/wxa/apply_merchant?access_token=ACCESS_TOKEN";
  }
}
