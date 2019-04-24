package me.gaigeshen.wechat.mp;

import lombok.Builder;
import lombok.Getter;

/**
 * 配置
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class Config {
  private String appid;
  private String secret;
  private String token;
  private String encodingAesKey;
  private MessageEncryptionType messageEncryptionType;
}
