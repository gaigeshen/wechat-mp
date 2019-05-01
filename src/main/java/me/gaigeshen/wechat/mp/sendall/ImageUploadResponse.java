package me.gaigeshen.wechat.mp.sendall;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 上传图文消息内的图片的结果
 *
 * @author gaigeshen
 */
@Getter
public class ImageUploadResponse extends AbstractResponse {
  private String url;
}
