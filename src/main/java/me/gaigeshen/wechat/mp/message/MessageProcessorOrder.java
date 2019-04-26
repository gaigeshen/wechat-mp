package me.gaigeshen.wechat.mp.message;

/**
 *
 * @author gaigeshen
 */
public @interface MessageProcessorOrder {

  int value() default Integer.MAX_VALUE;

}
