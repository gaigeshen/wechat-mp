package me.gaigeshen.wechat.mp.message;

import me.gaigeshen.wechat.mp.Config;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.Validate;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 消息体加解密处理器，改造自微信加解密样例
 *
 * @author gaigeshen
 */
final class MessageCodecProcessor {
  private final Config config;
  private final byte[] encodingAesKey;

  /**
   * 创建消息体加解密处理器
   *
   * @param config 配置
   */
  MessageCodecProcessor(Config config) {
    Validate.notNull(config, "config is required");
    this.config = config;
    this.encodingAesKey = Base64.decodeBase64(config.getEncodingAesKey() + "=");
  }

  /**
   * 解密消息内容
   *
   * @param encrypted 加密的消息内容
   * @param validateMessageTo 是否需要校验消息接收者，密文里面表达的消息接收者必须与当前配置的应用编号是否需要相同
   * @return 得到解密后的内容
   */
  String decrypt(String encrypted, boolean validateMessageTo) {
    byte[] decryptedBytes = decryptInternal(encrypted, encodingAesKey);
    int pad = decryptedBytes[decryptedBytes.length - 1];
    if (pad < 1 || pad > 32) {
      pad = 0;
    }
    byte[] bytesRemovedPad = Arrays.copyOfRange(decryptedBytes, 0, decryptedBytes.length - pad);
    byte[] networkBytes = Arrays.copyOfRange(bytesRemovedPad, 16, 20);
    int sourceNumber = 0;
    for (int i = 0; i < 4; i++) {
      sourceNumber <<= 8;
      sourceNumber |= networkBytes[i] & 0xff;
    }
    String plainMessageBody = new String(Arrays.copyOfRange(bytesRemovedPad, 20, 20 + sourceNumber));
    String toUserName = new String(Arrays.copyOfRange(bytesRemovedPad, 20 + sourceNumber, bytesRemovedPad.length));
    if (validateMessageTo && !config.getAppid().equals(toUserName)) {
      throw new IllegalStateException("Invalid message to: " + toUserName);
    }
    return plainMessageBody;
  }

  /**
   * 加密消息内容
   *
   * @param plainMessageBody 未加密的消息内容
   * @return 得到加密后的内容
   */
  String encrypt(String plainMessageBody) {
    byte[] random = RandomStringUtils.randomAlphanumeric(16).getBytes();
    byte[] bodyBytes = plainMessageBody.getBytes();
    int bodyBytesLength = bodyBytes.length;
    byte[] networkBytes = new byte[]{
      (byte) (bodyBytesLength >> 24 & 0xff),
      (byte) (bodyBytesLength >> 16 & 0xff),
      (byte) (bodyBytesLength >> 8 & 0xff),
      (byte) (bodyBytesLength & 0xff)
    };
    byte[] appidBytes = config.getAppid().getBytes();
    byte[] allBytes = concatBytes(random, networkBytes, bodyBytes, appidBytes);
    int padAmount = 32 - (allBytes.length % 32);
    char padChr = (char) (padAmount & 0xff);
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < padAmount; i++) {
      builder.append(padChr);
    }
    byte[] finalBytes = ArrayUtils.addAll(allBytes, builder.toString().getBytes());
    return encryptInternal(finalBytes, encodingAesKey);
  }

  /**
   * 解密加密的字符串
   *
   * @param encrypted 加密的字符串
   * @param encodingAesKey 加密秘钥
   * @return 解密后的字节数组
   */
  private byte[] decryptInternal(String encrypted, byte[] encodingAesKey) {
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
      SecretKeySpec keySpec = new SecretKeySpec(encodingAesKey, "AES");
      IvParameterSpec iv = new IvParameterSpec(encodingAesKey, 0, 16);
      cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
      byte[] encryptedBytes = Base64.decodeBase64(encrypted);
      return cipher.doFinal(encryptedBytes);
    } catch (Exception e) {
      throw new IllegalStateException("Could not do encript", e);
    }
  }

  /**
   * 加密字节数组
   *
   * @param bytes 字节数组
   * @param encodingAesKey 加密秘钥
   * @return 加密后的字符串
   */
  private String encryptInternal(byte[] bytes, byte[] encodingAesKey) {
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
      SecretKeySpec keySpec = new SecretKeySpec(encodingAesKey, "AES");
      IvParameterSpec iv = new IvParameterSpec(encodingAesKey, 0, 16);
      cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
      byte[] encrypted = cipher.doFinal(bytes);
      return new String(Base64.encodeBase64(encrypted), StandardCharsets.UTF_8);
    } catch (Exception e) {
      throw new IllegalStateException("Could not do encript", e);
    }
  }

  /**
   * 连接多个字节数组
   *
   * @param bytesArray 多个字节数组，如果没有传递，则返回空数组
   * @return 连接后的字节数组
   */
  private byte[] concatBytes(byte[]... bytesArray) {
    if (bytesArray == null) {
      return new byte[0];
    }
    byte[] allBytes = null;
    for (byte[] bytes : bytesArray) {
      allBytes = ArrayUtils.addAll(allBytes, bytes);
    }
    return allBytes;
  }
}
