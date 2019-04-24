package me.gaigeshen.wechat.mp.message;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.StringReader;
import java.lang.reflect.Field;

/**
 * 消息体帮助类
 *
 * @author gaigeshen
 */
public class MessageBodyHelper {

  private final Document document;

  private MessageBodyHelper(String messageBody) {
    Validate.notBlank(messageBody, "messageBody cannot blank");
    try {
      this.document = new SAXReader().read(new StringReader(messageBody));
    } catch (DocumentException e) {
      throw new IllegalStateException("Could not create message body helper with: " + messageBody, e);
    }
  }

  /**
   * 创建消息体帮助类
   *
   * @param messageBody 消息体字符串
   * @return 消息体帮助类
   */
  public static MessageBodyHelper create(String messageBody) {
    return new MessageBodyHelper(messageBody);
  }

  /**
   * 转换为指定的消息类型的对象
   *
   * @param messageType 消息类型
   * @param <R> 指定的消息类型
   * @return 指定的消息类型的对象
   */
  public <R extends AbstractMessage> R parseToObject(Class<R> messageType) {
    R message;
    try {
      message = messageType.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new IllegalStateException("Could not create new message object: " + messageType, e);
    }
    Field[] fields = FieldUtils.getAllFields(messageType);
    for (Field field : fields) {
      field.setAccessible(true);
      // 字段名称的首字母是小写的，转成大写之后去寻找对应的节点
      String fieldName = field.getName();
      String elementName = StringUtils.left(fieldName, 1).toUpperCase() + fieldName.substring(1);
      Element node = (Element) document.selectSingleNode("//" + elementName);
      if (node == null) {
        continue; // 可能不存在该字段
      }
      assignFieldValue(field, message, node.getTextTrim());
    }
    return message;
  }

  private static void assignFieldValue(Field field, Object message, String value) {
    Class<?> fieldType = field.getType();
    try {
      if (fieldType == String.class) {
        field.set(message, value);
      }
      else if (ClassUtils.isAssignable(int.class, fieldType)) {
        field.set(message, Integer.valueOf(value));
      }
      else if (ClassUtils.isAssignable(long.class, fieldType)) {
        field.set(message, Long.valueOf(value));
      }
      else if (ClassUtils.isAssignable(double.class, fieldType)) {
        field.set(message, Double.valueOf(value));
      }
    } catch (IllegalAccessException e) {
      throw new IllegalStateException("Could not assign value to message field: " + field, e);
    }
  }
}
