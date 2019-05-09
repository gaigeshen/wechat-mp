package me.gaigeshen.wechat.mp.message;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 消息节点名称
 *
 * @author gaigeshen
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NodeName {
  /**
   * 在解析消息内容的时候，可以通过自定义消息某个节点的名称，
   * 来决定类的某个字段将读取消息中特定名称的节点的值
   *
   * @return 消息节点名称
   */
  String value() default "";
}
