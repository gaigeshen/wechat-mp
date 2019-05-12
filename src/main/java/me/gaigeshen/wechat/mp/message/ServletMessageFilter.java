package me.gaigeshen.wechat.mp.message;

import lombok.extern.slf4j.Slf4j;
import me.gaigeshen.wechat.mp.Config;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 消息处理过滤器，通常可以与依赖注入框架结合使用
 *
 * @author gaigeshen
 */
@Slf4j
@WebFilter("/messages")
public class ServletMessageFilter implements Filter {

  private final Config config;
  private final MessageProcessorChain processorChain;

  /**
   * 创建消息处理过滤器
   *
   * @param config 配置
   * @param processorChain 消息处理器链
   */
  public ServletMessageFilter(Config config, MessageProcessorChain processorChain) {
    Validate.notNull(config, "config is required");
    Validate.notNull(processorChain, "processor chain is required");
    this.config = config;
    this.processorChain = processorChain;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    log.debug("Initializing servlet message filter");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
          throws IOException, ServletException {
    if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
      if (StringUtils.isNotBlank(request.getParameter("echostr"))) {
        // 首次接入的时候，对方会带特定的参数过来
        // 验证消息来源合法之后将该参数值原封不动回复
        ServletMessageSourceValidator.create(config, (HttpServletRequest) request, (HttpServletResponse) response)
                .doValidateAndRespond();
      } else {
        // 不是首次接入，将会收到各种消息和事件推送
        // 交给消息处理器链继续处理
        // 有可能需要回复，也有可能不需要回复
        ServletMessageRequest messageRequest = ServletMessageRequest.create(config, (HttpServletRequest) request);
        ServletReplyMessageResponse messageResponse = ServletReplyMessageResponse.create(config, (HttpServletResponse) response);
        processorChain.doProcess(messageRequest.getMessage(), messageResponse);
      }
      return;
    }
    chain.doFilter(request, response);
  }

  @Override
  public void destroy() {
    log.debug("Destroying servlet message filter");
  }
}
