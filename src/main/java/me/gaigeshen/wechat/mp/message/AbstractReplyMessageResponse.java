package me.gaigeshen.wechat.mp.message;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import me.gaigeshen.wechat.mp.Config;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author gaigeshen
 */
public abstract class AbstractReplyMessageResponse implements ReplyMessageResponse {

  private static final String CONTENT_TYPE_PLAIN = "text/plain:charset=utf-8";
  private static final String CONTENT_TYPE_XML = "text/xml;charset=utf-8";

  private static final XStream XS_FACADE_LIB;
  static {
    XS_FACADE_LIB = new XStream(new StaxDriver());
    XS_FACADE_LIB.autodetectAnnotations(true);
  }

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
    Document document;
    try {
      document = new SAXReader().read(new StringReader(XS_FACADE_LIB.toXML(message)));
    } catch (DocumentException e) {
      throw new IllegalStateException("Could not parse to reply body", e);
    }
    if (!StringUtils.isNotBlank(config.getEncodingAesKey())) {
      write(document.asXML(), CONTENT_TYPE_XML);
    } else {
      write(String.format("<xml>" +
                      "<ToUserName><![CDATA[%s]]</ToUserName>" +
                      "<Encrypt><![CDATA[%s]]</Encrypt>" +
                      "</xml>",
              message.getToUserName(), new MessageCodecProcessor(config).encrypt(document.asXML())), CONTENT_TYPE_XML);
    }
  }

  /**
   *
   *
   * @param replyMessageBody
   * @param contentType
   * @throws IOException
   */
  protected abstract void write(String replyMessageBody, String contentType) throws IOException ;
}
