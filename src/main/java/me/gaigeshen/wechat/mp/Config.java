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
  /**
   * 用于签名生成或者校验
   */
  private String token;
  /**
   * 消息加解密秘钥，如果已配置，则会导致所有接收到的消息尝试解密之后再处理，且发出的消息也会先进行加密。
   */
  private String encodingAesKey;
}
