package me.gaigeshen.wechat.mp.message;

import me.gaigeshen.wechat.mp.Config;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author gaigeshen
 */
public class ServletMessageRequest extends AbstractMessageRequest {

  public static ServletMessageRequest create(Config config, HttpServletRequest request) {
    String timestamp = request.getParameter("timestamp");
    String nonce = request.getParameter("nonce");
    String encryptType = request.getParameter("encrypt_type");
    String sign = request.getParameter("msg_signature");

    ByteArrayOutputStream messageBodyBytes = new ByteArrayOutputStream();
    int len;
    byte[] buffer = new byte[2048];
    try {
      ServletInputStream in = request.getInputStream();
      while ((len = in.read(buffer)) > 0) {
        messageBodyBytes.write(buffer, 0, len);
      }
    } catch (IOException e) {
      throw new IllegalStateException("Could not read message data from: " + request, e);
    }

    return new ServletMessageRequest(config, timestamp, nonce,
            new String(messageBodyBytes.toByteArray(), Charset.forName("utf-8")),
            encryptType, sign);
  }

  private ServletMessageRequest(Config config, String timestamp, String nonce, String messageBody, String encryptType, String sign) {
    super(config, timestamp, nonce, messageBody, encryptType, sign);
  }
}
