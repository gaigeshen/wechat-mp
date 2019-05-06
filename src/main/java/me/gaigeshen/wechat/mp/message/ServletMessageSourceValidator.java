package me.gaigeshen.wechat.mp.message;

import me.gaigeshen.wechat.mp.Config;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 * @author gaigeshen
 */
public class ServletMessageSourceValidator {

  private final Config config;
  private final HttpServletRequest request;
  private final HttpServletResponse response;

  private ServletMessageSourceValidator(Config config, HttpServletRequest request, HttpServletResponse response) {
    this.config = config;
    this.request = request;
    this.response = response;
  }

  public static ServletMessageSourceValidator create(Config config, HttpServletRequest request, HttpServletResponse response) {
    return new ServletMessageSourceValidator(config, request, response);
  }

  /**
   * 执行验证消息来源是否合法，不管是否合法都会回复文本内容至响应
   *
   * @throws IOException 回复的时候发生异常
   */
  public void doValidateAndRespond() throws IOException {
    response.setContentType("text/plain");

    String signature = request.getParameter("signature");
    String timestamp = request.getParameter("timestamp");
    String nonce = request.getParameter("nonce");
    String echostr = request.getParameter("echostr");
    if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
      response.getWriter().write("failed");
      return;
    }
    if (!MessageSourceValidator.validate(config.getToken(), signature, timestamp, nonce)) {
      response.getWriter().write("failed");
    } else {
      response.getWriter().write(echostr);
    }
  }
}
