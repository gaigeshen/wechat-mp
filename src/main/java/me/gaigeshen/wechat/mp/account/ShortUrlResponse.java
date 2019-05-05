package me.gaigeshen.wechat.mp.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 长连接转短连接结果
 *
 * @author gaigeshen
 */
@Getter
public class ShortUrlResponse extends AbstractResponse {
  @JSONField(name = "short_url")
  private String shortUrl;
}
