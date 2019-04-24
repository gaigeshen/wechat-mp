package me.gaigeshen.wechat.mp;

/**
 * 请求结果
 *
 * @author gaigeshen
 */
public interface Response {
  /**
   * 返回是否是成功的请求结果
   *
   * @return 是否是成功的请求结果
   */
  boolean isSucceeded();

  /**
   * 返回错误的消息如果不是成功的请求的话
   *
   * @return 错误的消息
   */
  String getErrorMessage();
}
