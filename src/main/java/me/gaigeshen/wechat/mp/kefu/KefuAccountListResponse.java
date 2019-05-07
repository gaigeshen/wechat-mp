package me.gaigeshen.wechat.mp.kefu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取所有的客服帐号结果
 *
 * @author gaigeshen
 */
@Getter
public class KefuAccountListResponse extends AbstractResponse {

  @JSONField(name = "kf_list")
  private Account[] accounts;

  @Getter
  public static class Account {
    @JSONField(name = "kf_id")
    private String id;
    @JSONField(name = "kf_account")
    private String account;
    @JSONField(name = "kf_nick")
    private String nickname;
    @JSONField(name = "kf_headimgurl")
    private String headimgurl;
  }
}
