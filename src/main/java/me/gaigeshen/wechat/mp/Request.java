package me.gaigeshen.wechat.mp;

import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 请求，不同的请求类型实现此接口，该类型对象的所有字段的值将作为请求参数
 *
 * @param <R> 限定的请求结果类型
 * @author gaigeshen
 */
public interface Request<R extends Response> {
  /**
   * 返回请求结果类型
   *
   * @return 请求结果类型，请求结果将会转换为此类型的对象
   */
  Class<R> responseType();

  /**
   * 返回请求方式
   * <pre>
   * 1. GET - 用于获取数据
   * 2. POST - 只有此方式才会提交请求体参数，请求体参数来自本对象的所有字段
   * </pre>
   *
   * @return 请求方式
   */
  HttpMethod httpMethod();

  /**
   * 返回请求地址，也许会带以下参数，将会被替换为实际的值。<br>
   * <pre>
   * 1. APPID
   * 2. SECRET
   * 3. ACCESS_TOKEN - 无需配置，执行该请求时内部自动获得
   * </pre>
   *
   * @return 请求地址
   */
  String requestUri();
}
