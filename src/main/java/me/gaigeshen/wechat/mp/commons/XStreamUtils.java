package me.gaigeshen.wechat.mp.commons;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.StringReader;

/**
 * @author gaigeshen
 */
public final class XStreamUtils {
  private static final XStream XS_FACADE_LIB;
  static {
    XS_FACADE_LIB = new XStream(new StaxDriver());
    XS_FACADE_LIB.autodetectAnnotations(true);
  }
  private XStreamUtils() {}

  /**
   * 将对象转换为文档对象
   *
   * @param object 对象实例
   * @return 文档对象
   *
   * @throws IllegalArgumentException 转换失败的时候会抛此异常
   */
  public static Document parseToDocument(Object object) {
    return parseToDocument(XS_FACADE_LIB.toXML(object));
  }

  /**
   * 将字符串转换为文档对象
   *
   * @param xml 字符串
   * @return 文档对象
   *
   * @throws IllegalArgumentException 转换失败的时候会抛此异常
   */
  public static Document parseToDocument(String xml) {
    try {
      return new SAXReader().read(new StringReader(xml));
    } catch (DocumentException e) {
      throw new IllegalArgumentException("Could not parse to document object from xml string: " + xml);
    }
  }
}
