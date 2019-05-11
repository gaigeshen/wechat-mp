package me.gaigeshen.wechat.mp.message;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.dom4j.Document;
import org.dom4j.Element;

import java.lang.reflect.Field;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

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
    if (response instanceof KeyMappedMessage) { // 未定义的消息类型
      processNestedKeyMappedMessage((KeyMappedMessage) response, document.getRootElement());
      return response;
    }
    Field[] fields = FieldUtils.getAllFields(targetType);
    for (Field field : fields) {
      field.setAccessible(true);
      String nodeNameValue = null;
      NodeName nodeName = field.getAnnotation(NodeName.class);
      if (nodeName != null) {
        nodeNameValue = nodeName.value();
      }
      if (nodeNameValue == null) {
        String fieldName = field.getName();
        nodeNameValue = StringUtils.left(fieldName, 1).toUpperCase() + fieldName.substring(1);
      }
      Element node = (Element) document.selectSingleNode("//" + nodeNameValue);
      if (node == null) {
        continue; // 可能不存在该字段
      }
      assignFieldValue(field, response, node.getTextTrim());
    }
    return response;
  }

  /**
   * 处理可能存在嵌套格式的消息
   *
   * @param properties 将会将消息内容数据放入此映射，如果存在嵌套数据，将会处理为嵌套的映射
   * @param rootElement 消息根节点
   */
  private static void processNestedKeyMappedMessage(Map<String, Object> properties, Element rootElement) {
    if (rootElement == null) {
      return;
    }
    for (Element childElement : rootElement.elements()) {
      List<Element> elements = childElement.elements();
      if (elements.isEmpty()) { // 如果不存在子节点，则直接添加至映射
        properties.put(childElement.getName() + "", childElement.getTextTrim());
      } else { // 如果存在子节点，则继续处理子节点
        Map<String, Object> props = new IdentityHashMap<>(elements.size());
        processNestedKeyMappedMessage(props, childElement);
        properties.put(childElement.getName() + "", props);
      }
    }
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
