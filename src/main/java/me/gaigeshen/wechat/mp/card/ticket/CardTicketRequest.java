package me.gaigeshen.wechat.mp.card.ticket;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 卡券票据获取
 *
 * @author gaigeshen
 */
public class CardTicketRequest implements Request<CardTicketResponse> {
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.GET;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=wx_card";
  }
}
