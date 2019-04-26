package me.gaigeshen.wechat.mp.message;

import me.gaigeshen.wechat.mp.Config;
import org.apache.commons.lang3.Validate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gaigeshen
 */
public class ServletReplyMessageResponse extends AbstractReplyMessageResponse {

  private final HttpServletResponse response;

  private ServletReplyMessageResponse(Config config, HttpServletResponse response) {
    super(config);
    Validate.notNull(response, "response is required");
    this.response = response;
  }

  public static ServletReplyMessageResponse create(Config config, HttpServletResponse response) {
    return new ServletReplyMessageResponse(config, response);
  }

  @Override
  protected void write(String replyMessageBody, String contentType) throws IOException {
    response.setHeader("Content-Type", contentType);
    response.getWriter().write(replyMessageBody);
  }
}
