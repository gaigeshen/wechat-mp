package me.gaigeshen.wechat.mp.shakearound.redpack;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;

/**
 * 创建红包活动
 *
 * @author gaigeshen
 */
@Builder
public class RedpackActivityCreateRequest implements Request<RedpackActivityCreateResponse> {
  @JSONField(name = "title") private String title;
  @JSONField(name = "desc") private String desc;
  @JSONField(name = "onoff") private int onoff;
  @JSONField(name = "begin_time") private long beginTime;
  @JSONField(name = "expire_time") private long expireTime;
  @JSONField(name = "sponsor_appid") private String sponsorAppid;
  @JSONField(name = "total") private long total;
  @JSONField(name = "jump_url") private String jumpUrl;
  @JSONField(name = "key") private String key;

  @JSONField(serialize = false)
  private boolean useTemplate;
  @JSONField(serialize = false)
  private String logoUrl;

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/shakearound/lottery/addlotteryinfo?access_token=ACCESSTOKEN&use_template="
            + (useTemplate ? 1: 2) + "&logo_url=" + logoUrl;
  }
}
