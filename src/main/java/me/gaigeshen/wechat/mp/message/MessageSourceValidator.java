package me.gaigeshen.wechat.mp.message;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

/**
 * 用于验证消息来源是否合法，开始接入
 *
 * @author gaigeshen
 */
public final class MessageSourceValidator {

  private MessageSourceValidator() {}

  /**
   * 验证方法
   *
   * @param token 签名计算密钥
   * @param signature 待验证的签名
   * @param timestamp 时间戳
   * @param nonce 随机值
   * @return 验证是否成功
   */
  public static boolean validate(String token, String signature, String timestamp, String nonce) {
    String[] arr = { token, timestamp, nonce};
    Arrays.sort(arr);
    StringBuilder builder = new StringBuilder();
    for (String str : arr) {
      builder.append(str);
    }
    return DigestUtils.sha1Hex(builder.toString()).equals(signature);
  }

}

