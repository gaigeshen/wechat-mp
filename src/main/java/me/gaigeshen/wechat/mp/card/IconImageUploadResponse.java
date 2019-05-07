package me.gaigeshen.wechat.mp.card;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 商户图标上传结果
 *
 * @author gaigeshen
 */
@Getter
public class IconImageUploadResponse extends AbstractResponse {
  private String url;
}
