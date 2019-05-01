package me.gaigeshen.wechat.mp.message;

import me.gaigeshen.wechat.mp.Config;
import org.apache.commons.lang3.Validate;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.StringReader;

/**
 * @author gaigeshen
 */
public abstract class AbstractMessageRequest implements MessageRequest {

  private static final String MSG_TYPE_FIELD = "//MsgType";
  private static final String MSG_EVENT_TYPE_FIELD = "//Event";
  private static final String MSG_ENCRYPT_FIELD = "//Encrypt";

  private final Config config;

  private final String timestamp;
  private final String nonce;
  private final String messageBody;

  private final Document messageBodyDocument;

  private Message message;

  private String encryptType;
  private String sign;

  protected AbstractMessageRequest(Config config, String timestamp, String nonce, String messageBody) {
    Validate.notNull(config, "config is required");
    Validate.notBlank(timestamp, "timestamp is requried");
    Validate.notBlank(nonce, "nonce is requried");
    Validate.notBlank(messageBody, "messageBody is required");
    this.config = config;
    this.timestamp = timestamp;
    this.nonce = nonce;
    this.messageBody = messageBody;
    try {
      this.messageBodyDocument = parseToDocument(messageBody);
    } catch (DocumentException e) {
      throw new IllegalArgumentException("Invalid message body: " + messageBody, e);
    }
  }

  protected AbstractMessageRequest(Config config, String timestamp, String nonce, String messageBody, String encryptType, String sign) {
    this(config, timestamp, nonce, messageBody);
    this.encryptType = encryptType;
    this.sign = sign;
  }

  @Override
  public final synchronized Message getMessage() {
    if (message == null) {
      // 取消息类型
      Element node = (Element) messageBodyDocument.selectSingleNode(MSG_TYPE_FIELD);
      Validate.notNull(node, "Unable to determine message type from: " + messageBodyDocument);
      String messageType = node.getTextTrim();
      if (isEventMessageType(messageType)) {
        // 如果消息类型是事件推送
        // 则继续取事件类型
        node = (Element) messageBodyDocument.selectSingleNode(MSG_EVENT_TYPE_FIELD);
        Validate.notNull(node, "Unable to determine event type from: " + messageBodyDocument);
        messageType = node.getTextTrim();
      }
      // 得到的消息类型可能为事件类型，也有可能是普通消息类型
      message = MessageRequestXmlUtils.parseToObject(messageBodyDocument, MessageTypeDeclarer.messageClassFromName(messageType));
    }
    return message;
  }

  /**
   * 判断消息类型是否是事件类型，事件类型也属于消息类型
   *
   * @param messageType 消息类型
   * @return 是否是事件类型
   */
  private boolean isEventMessageType(String messageType) {
    return "event".equals(messageType);
  }

  private Document parseToDocument(String messageBody) throws DocumentException {
    Document document = parseToDocumentInternal(messageBody);
    Element node = (Element) document.selectSingleNode(MSG_ENCRYPT_FIELD);
    if (node != null) {
      String encrypted = node.getTextTrim();
      String decrypted = new MessageCodecProcessor(config).decrypt(encrypted, true);
      document = parseToDocumentInternal(decrypted);
    }
    return document;
  }

  private Document parseToDocumentInternal(String content) throws DocumentException {
    return new SAXReader().read(new StringReader(content));
  }
}
