package me.gaigeshen.wechat.mp;

import me.gaigeshen.wechat.mp.commons.HttpMethod;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 请求，不同的请求类型实现此接口，该类型对象的所有字段的值将作为请求参数。如果需要自定义请求类型，请保证直接实现此接口，不要间接实现。
 *
 * @param <R> 限定的请求结果类型
 * @author gaigeshen
 */
public interface Request<R extends Response> {

  /**
   * 帮助类，无须使用
   *
   * @author gaigeshen
   */
  class Helper {
    /**
     * 获取指定类型实现的的参数化接口，且该接口为请求类型
     *
     * @param clazz 指定的类型
     * @return 参数化接口
     */
    private static ParameterizedType requestType(Class<?> clazz) {
      Type[] genericInterfaces = clazz.getGenericInterfaces();
      if (genericInterfaces != null) {
        for (Type anInterface : genericInterfaces) {
          if (anInterface instanceof ParameterizedType) {
            if (((ParameterizedType) anInterface).getRawType().equals(Request.class)) {
              return (ParameterizedType) anInterface;
            }
          }
        }
      }
      throw new IllegalStateException("Invalid class declared of request: " + clazz);
    }
  }

  /**
   * 返回请求结果类型，可以选择重写，也可以不重写，会自动获取
   *
   * @return 请求结果类型，请求结果将会转换为此类型的对象
   */
  @SuppressWarnings("unchecked")
  default Class<R> responseType() {
    return (Class<R>) Helper.requestType(getClass()).getActualTypeArguments()[0];
  }

  /**
   * 返回请求方式
   * <pre>
   * 1. GET - 用于获取数据
   * 2. POST - 只有此方式才会提交请求体参数，请求体参数来自本对象的所有字段，默认此方式
   * </pre>
   *
   * @return 请求方式
   */
  default HttpMethod httpMethod() {
    return HttpMethod.POST;
  }

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
