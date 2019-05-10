package me.gaigeshen.wechat.mp.kefu.newapi;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取客服列表结果
 *
 * @author gaigeshen
 */
@Getter
public class KefuListResponse extends AbstractResponse {

  @JSONField(name = "kf_list")
  private Kefu[] kefus;

  @Getter
  public static class Kefu {
    @JSONField(name = "kf_account") private String account;
    @JSONField(name = "kf_headimgurl") private String headimgurl;
    @JSONField(name = "kf_id") private String id;
    @JSONField(name = "kf_nick") private String nick;
    @JSONField(name = "kf_wx") private String wx;
  }
}
