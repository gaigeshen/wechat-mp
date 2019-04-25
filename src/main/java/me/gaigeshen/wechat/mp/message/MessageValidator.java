package me.gaigeshen.wechat.mp.message;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

/**
 * 消息验证器
 *
 * @author gaigeshen
 */
public final class MessageValidator {

  /**
   * 验证消息签名
   *
   * @param signature 签名
   * @param token 签名秘钥
   * @param timestamp 时间戳字符串
   * @param nonce 随机字符串
   * @param encrypted 加密后的消息字符串
   * @return 是否验证成功
   */
  private static boolean validate(String signature, String token, String timestamp, String nonce, String encrypted) {
    String[] arr = new String[] { token, timestamp, nonce, encrypted};
    Arrays.sort(arr);
    StringBuilder builder = new StringBuilder();
    for (String str : arr) {
      builder.append(str);
    }
    return DigestUtils.sha1Hex(builder.toString()).equals(signature);
  }
  /**
   * 验证消息来源
   *
   * @param signature 签名
   * @param token 签名秘钥
   * @param timestamp 时间戳
   * @param nonce 随机数
   * @return 是否验证成功
   */
  public static boolean validateSource(String signature, String token, String timestamp, String nonce) {
    String[] arr = new String[] { token, timestamp, nonce };
    Arrays.sort(arr);
    StringBuilder builder = new StringBuilder();
    for (String str : arr) {
      builder.append(str);
    }
    return DigestUtils.sha1Hex(builder.toString()).equals(signature);
  }
}
