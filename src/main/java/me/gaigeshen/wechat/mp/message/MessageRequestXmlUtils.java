package me.gaigeshen.wechat.mp.message;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.dom4j.Document;
import org.dom4j.Element;

import java.lang.reflect.Field;

/**
 *
 * 消息请求体工具类，用于转换消息请求体的数据至指定的类型的消息对象
 *
 * @author gaigeshen
 */
final class MessageRequestXmlUtils {

  /**
   *
   * @param document 消息文档内容
   * @param targetType 指定类型
   * @return 指定的类型的对象
   */
  static <R extends Message> R parseToObject(Document document, Class<R> targetType) {
    R response;
    try {
      response = targetType.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new IllegalStateException("Could not create new response object: " + targetType, e);
    }
    Field[] fields = FieldUtils.getAllFields(targetType);
    for (Field field : fields) {
      field.setAccessible(true);
      String fieldName = field.getName();
      Element node = (Element) document.selectSingleNode("//" + StringUtils.left(fieldName, 1).toUpperCase() + fieldName.substring(1));
      if (node == null) {
        continue; // 可能不存在该字段
      }
      assignFieldValue(field, response, node.getTextTrim());
    }
    return response;
  }

  private static void assignFieldValue(Field field, Object target, String value) {
    Class<?> fieldType = field.getType();
    try {
      if (fieldType == String.class) {
        field.set(target, value);
      }
      else if (ClassUtils.isAssignable(int.class, fieldType)) {
        field.set(target, Integer.valueOf(value));
      }
      else if (ClassUtils.isAssignable(long.class, fieldType)) {
        field.set(target, Long.valueOf(value));
      }
      else if (ClassUtils.isAssignable(double.class, fieldType)) {
        field.set(target, Double.valueOf(value));
      }
      else if (ClassUtils.isAssignable(boolean.class, fieldType)) {
        field.set(target, Boolean.valueOf(value));
      }
    } catch (IllegalAccessException e) {
      throw new IllegalStateException("Could not assign value to target field: " + field, e);
    }
  }
}
