package me.gaigeshen.wechat.mp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;

/**
 * 服务器地址结果
 *
 * @author gaigeshen
 */
@Getter
public class ServerAddressResponse extends AbstractResponse {
  @JSONField(name = "ip_list")
  private String[] addresses;
}
