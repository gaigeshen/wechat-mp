package me.gaigeshen.wechat.mp.store;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 上传新建门店时所使用的图片的结果
 *
 * @author gaigeshen
 */
@Getter
public class StoreImageUploadResponse extends AbstractResponse {
  private String url;
}
