package me.gaigeshen.wechat.mp.kefu.newapi;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取在线客服列表结果
 *
 * @author gaigeshen
 */
@Getter
public class KefuOnlineListResponse extends AbstractResponse {

  @JSONField(name = "kf_online_list")
  private Kefu[] kefus;

  @Getter
  public static class Kefu {
    @JSONField(name = "kf_id") private String id;
    @JSONField(name = "kf_account") private String account;
    @JSONField(name = "status") private String status;
    @JSONField(name = "accepted_case") private Integer acceptedCase;
  }
}
