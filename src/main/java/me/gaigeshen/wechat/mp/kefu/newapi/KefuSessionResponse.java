package me.gaigeshen.wechat.mp.kefu.newapi;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取客服会话状态结果
 *
 * @author gaigeshen
 */
@Getter
public class KefuSessionResponse extends AbstractResponse {
  @JSONField(name = "createtime")
  private Long createTime;
  @JSONField(name = "kf_account")
  private String account;
}
