package me.gaigeshen.wechat.mp.message;

import me.gaigeshen.wechat.mp.Config;
import me.gaigeshen.wechat.mp.commons.XStreamUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.dom4j.Document;

import java.io.IOException;

/**
 * 抽象回复消息响应
 *
 * @author gaigeshen
 */
public abstract class AbstractReplyMessageResponse implements ReplyMessageResponse {

  private static final String CONTENT_TYPE_PLAIN = "text/plain:charset=utf-8";
  private static final String CONTENT_TYPE_XML = "text/xml;charset=utf-8";

  // 回复加密消息的时候，就是这种格式
  private static final String ENCRYPTED_MESSAGE_REPLY_CONTENT = "" +
          "<xml>" +
          "<Encrypt><![CDATA[%s]]></Encrypt>" +
          "<MsgSignature><![CDATA[%s]]></MsgSignature>" +
          "<TimeStamp><![CDATA[%s]]></TimeStamp>" +
          "<Nonce><![CDATA[%s]]></Nonce>" +
          "</xml>";

  private final Config config;

  protected AbstractReplyMessageResponse(Config config) {
    Validate.notNull(config, "config is required");
    this.config = config;
  }

  @Override
  public final void write(ReplyMessage message) throws IOException {
    Validate.notNull(message, "message is required");
    if (message.equals(ReplyMessage.BLANK)) {
      write("success", CONTENT_TYPE_PLAIN);
      return;
    }
    Document document = XStreamUtils.parseToDocument(message);
    if (StringUtils.isBlank(config.getEncodingAesKey())) { // 无须加密
      write(document.asXML(), CONTENT_TYPE_XML);
    } else {
      long timestamp = System.currentTimeMillis() / 1000;
      // 随机值
      String nonce = RandomStringUtils.randomAlphanumeric(10);
      // 加密消息体内容
      String encryptedMessageBody = new MessageCodecProcessor(config).encrypt(document.asXML());
      // 计算消息体内容的签名
      String messageBodySignature = MessageSourceValidator.calculateMessageBodySignature(
              config.getToken(), timestamp + "", nonce, encryptedMessageBody);
      // 写出回复消息
      write(String.format(ENCRYPTED_MESSAGE_REPLY_CONTENT,
              encryptedMessageBody, messageBodySignature, timestamp, nonce), CONTENT_TYPE_XML);
    }
  }

  /**
   * 写出回复消息
   *
   * @param replyMessageBody 回复消息内容，可直接写出
   * @param contentType 消息内容类型
   * @throws IOException 写出回复消息的时候发生异常
   */
  protected abstract void write(String replyMessageBody, String contentType) throws IOException ;
}
