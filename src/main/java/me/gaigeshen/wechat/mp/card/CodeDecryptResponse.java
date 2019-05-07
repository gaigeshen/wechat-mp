package me.gaigeshen.wechat.mp.card;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 解码卡券码结果
 *
 * @author gaigeshen
 */
@Getter
public class CodeDecryptResponse extends AbstractResponse {
  private String code;
}
