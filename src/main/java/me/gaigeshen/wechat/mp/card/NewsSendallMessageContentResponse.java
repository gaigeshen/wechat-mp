package me.gaigeshen.wechat.mp.card;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 图文消息群发卡券结果，返回的内容可直接放入群发图文消息内
 *
 * @author gaigeshen
 */
@Getter
public class NewsSendallMessageContentResponse extends AbstractResponse {
  private String content;
}
