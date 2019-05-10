package me.gaigeshen.wechat.mp.kefu.newapi;

import lombok.Builder;
import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.UploadItem;

/**
 * 上传客服头像
 *
 * @author gaigeshen
 */
@Builder
public class KefuAvatarUploadRequest implements Request<EmptyDataResponse> {
  private String account;
  private UploadItem media;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=" + account;
  }
}
