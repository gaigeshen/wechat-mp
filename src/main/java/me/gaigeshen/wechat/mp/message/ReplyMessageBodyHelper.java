package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.apache.commons.lang3.Validate;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.StringReader;

/**
 * 回复消息体帮助类
 *
 * @author gaigeshen
 */
public class ReplyMessageBodyHelper {

  private static final XStream XS_FACADE_LIB;
  static {
    XS_FACADE_LIB = new XStream(new StaxDriver());
    XS_FACADE_LIB.autodetectAnnotations(true);
  }

  private final ReplyMessage message;
  private final String toUserName;
  private final String fromUserName;
  private final String msgType;
  private final long createTime;

  private ReplyMessageBodyHelper(ReplyMessage message,
                                 String toUserName,
                                 String fromUserName,
                                 String msgType) {
    Validate.notNull(message, "message is required");
    Validate.notBlank(toUserName, "toUserName is blank");
    Validate.notBlank(fromUserName, "fromUserName is blank");
    Validate.notBlank(msgType, "msgType is blank");
    this.message = message;
    this.toUserName = toUserName;
    this.fromUserName = fromUserName;
    this.msgType = msgType;
    this.createTime = System.currentTimeMillis() / 1000;
  }

  public static ReplyMessageBodyHelper createForText(TextReplyMessage message, String toUserName, String fromUserName) {
    return create(message, toUserName, fromUserName, ReplyMessage.MSG_TYPE_TEXT);
  }

  public static ReplyMessageBodyHelper createForImage(ImageReplyMessage message, String toUserName, String fromUserName) {
    return create(message, toUserName, fromUserName, ReplyMessage.MSG_TYPE_IMAGE);
  }

  public static ReplyMessageBodyHelper createForVoice(VoiceReplyMessage message, String toUserName, String fromUserName) {
    return create(message, toUserName, fromUserName, ReplyMessage.MSG_TYPE_VOICE);
  }

  public static ReplyMessageBodyHelper createForVideo(VideoReplyMessage message, String toUserName, String fromUserName) {
    return create(message, toUserName, fromUserName, ReplyMessage.MSG_TYPE_VIDEO);
  }

  public static ReplyMessageBodyHelper createForMusic(MusicReplyMessage message, String toUserName, String fromUserName) {
    return create(message, toUserName, fromUserName, ReplyMessage.MSG_TYPE_MUSIC);
  }

  public static ReplyMessageBodyHelper createForNews(NewsReplyMessage message, String toUserName, String fromUserName) {
    return create(message, toUserName, fromUserName, ReplyMessage.MSG_TYPE_NEWS);
  }

  /**
   * 创建回复消息体帮助类
   *
   * @param message 消息对象
   * @param toUserName 消息将发往谁
   * @param fromUserName 消息来源自谁
   * @param msgType 消息类型
   * @return 回复消息体帮助类
   */
  public static ReplyMessageBodyHelper create(ReplyMessage message,
                                              String toUserName,
                                              String fromUserName,
                                              String msgType) {
    return new ReplyMessageBodyHelper(message, toUserName, fromUserName, msgType);
  }

  /**
   * 转换为回复消息字符串
   *
   * @return 回复消息字符串
   */
  public String toReplyBody() {
    Document document;
    try {
    // 消息对象转换为文档对象
      document = new SAXReader().read(new StringReader(XS_FACADE_LIB.toXML(message)));
    } catch (DocumentException e) {
      throw new IllegalStateException("Could not parse to reply body", e);
    }

    // 往根节点继续添加缺失的节点
    Element element = document.getRootElement();
    element.addElement("ToUserName").addCDATA(toUserName);
    element.addElement("FromUserName").addCDATA(fromUserName);
    element.addElement("CreateTime").addCDATA(createTime + "");
    element.addElement("MsgType").addCDATA(msgType);

    return document.asXML();
  }

}
