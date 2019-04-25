package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import me.gaigeshen.wechat.mp.Config;
import org.apache.commons.lang3.StringUtils;
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

  /**
   * 创建文本回复消息体帮助类
   *
   * @param message 文本回复消息
   * @param toUserName 发给谁
   * @param fromUserName 消息来自谁
   * @return 文本回复消息体帮助类
   */
  public static ReplyMessageBodyHelper createForText(TextReplyMessage message, String toUserName, String fromUserName) {
    return create(message, toUserName, fromUserName, ReplyMessage.MSG_TYPE_TEXT);
  }

  /**
   * 创建回复图片消息体帮助类
   *
   * @param message 回复图片消息
   * @param toUserName 发给谁
   * @param fromUserName 消息来自谁
   * @return 回复图片消息体帮助类
   */
  public static ReplyMessageBodyHelper createForImage(ImageReplyMessage message, String toUserName, String fromUserName) {
    return create(message, toUserName, fromUserName, ReplyMessage.MSG_TYPE_IMAGE);
  }

  /**
   * 创建回复语音消息体帮助类
   *
   * @param message 回复语音消息
   * @param toUserName 发给谁
   * @param fromUserName 消息来自谁
   * @return 回复语音消息体帮助类
   */
  public static ReplyMessageBodyHelper createForVoice(VoiceReplyMessage message, String toUserName, String fromUserName) {
    return create(message, toUserName, fromUserName, ReplyMessage.MSG_TYPE_VOICE);
  }

  /**
   * 创建回复视频消息体帮助类
   *
   * @param message 回复视频消息
   * @param toUserName 发给谁
   * @param fromUserName 消息来自谁
   * @return 回复视频消息体帮助类
   */
  public static ReplyMessageBodyHelper createForVideo(VideoReplyMessage message, String toUserName, String fromUserName) {
    return create(message, toUserName, fromUserName, ReplyMessage.MSG_TYPE_VIDEO);
  }

  /**
   * 创建回复音乐消息体帮助类
   *
   * @param message 回复音乐消息
   * @param toUserName 发给谁
   * @param fromUserName 消息来自谁
   * @return 回复音乐消息体帮助类
   */
  public static ReplyMessageBodyHelper createForMusic(MusicReplyMessage message, String toUserName, String fromUserName) {
    return create(message, toUserName, fromUserName, ReplyMessage.MSG_TYPE_MUSIC);
  }

  /**
   * 创建回复图文消息体帮助类
   *
   * @param message 回复图文消息
   * @param toUserName 发给谁
   * @param fromUserName 消息来自谁
   * @return 回复图文消息体帮助类
   */
  public static ReplyMessageBodyHelper createForNews(NewsReplyMessage message, String toUserName, String fromUserName) {
    return create(message, toUserName, fromUserName, ReplyMessage.MSG_TYPE_NEWS);
  }

  /**
   * 创建回复消息体帮助类，如非必要，不用调用此方法，可以先考虑调用其他创建具体类型的回复消息体帮助类的静态方法。
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
   * @param config 配置，如果需要加密请设置加密秘钥
   * @return 回复消息字符串
   */
  public String toReplyBody(Config config) {
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

    // 没有提供加密秘钥，不需要加密
    if (!StringUtils.isNotBlank(config.getEncodingAesKey())) {
      return document.asXML();
    }

    // 加密之后再返回
    return String.format("<xml>" +
                    "<ToUserName><![CDATA[%s]]</ToUserName>" +
                    "<Encrypt><![CDATA[%s]]</Encrypt>" +
                    "</xml>",
            toUserName, new MessageBodyCodecProcessor(config).encrypt(document.asXML()));
  }

}
