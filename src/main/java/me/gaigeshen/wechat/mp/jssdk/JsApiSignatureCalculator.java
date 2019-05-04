package me.gaigeshen.wechat.mp.jssdk;

import lombok.extern.slf4j.Slf4j;
import me.gaigeshen.wechat.mp.RequestExecutor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.Validate;

/**
 * 签名计算器（JSAPI），建议单例，否则有接口调用票据不足的风险
 *
 * @author gaigeshen
 */
@Slf4j
public final class JsApiSignatureCalculator {
  private final RequestExecutor executor;

  private String ticket; // 接口票据
  private long ticketExpiresAtTimestamp; // 接口票据过期时间戳

  /**
   * 创建签名生成器（JSAPI）
   *
   * @param executor 需要请求执行器用于获取接口请求票据
   */
  public JsApiSignatureCalculator(RequestExecutor executor) {
    Validate.notNull(executor, "executor is required");
    this.executor = executor;

    // 初次创建，提前初始化票据
    initializeTicket();
  }

  /**
   * 计算签名
   *
   * @param nonce 随机字符串
   * @param timestamp 时间戳精确到秒
   * @param url 链接地址，不包含井号后面的内容
   * @return 签名
   */
  public String calculate(String nonce, long timestamp, String url) {
    return DigestUtils.sha1Hex(
            "jsapi_ticket=" + currentTicket() +
            "&noncestr=" + nonce +
            "&timestamp=" + timestamp +
            "&url=" + url);
  }

  /**
   * 初始化票据
   */
  private void initializeTicket() {
    log.debug("Initialize ticket ...");
    refreshTicket(true);
  }

  /**
   * 返回当前有效的票据，如过期则会刷新
   *
   * @return 当前有效的票据
   */
  private String currentTicket() {
    if (System.currentTimeMillis() >= ticketExpiresAtTimestamp) {
      log.debug("Try to refresh the ticket");
      refreshTicket(false);
    }
    return ticket;
  }

  /**
   * 刷新票据
   *
   * @param force 是否强制刷新，如果强制刷新则不管当前是否已过期都会刷新
   */
  private synchronized void refreshTicket(boolean force) {
    long currentTimestamp = System.currentTimeMillis();
    if (!force && currentTimestamp < ticketExpiresAtTimestamp) {
      return;
    }
    JsApiTcketResponse resp = executor.execute(new JsApiTcketRequest());
    if (resp.isSucceeded()) {
      ticket = resp.getTicket();
      // 过期时间往前推移五秒钟，考虑请求的时间
      ticketExpiresAtTimestamp = currentTimestamp + (resp.getExpiresIn() * 1000 - 5000);
      log.debug("Ticket refresh succeeded");
    } else {
      log.debug("Ticket refresh failed: " + resp.getErrorMessage());
    }
  }
}
