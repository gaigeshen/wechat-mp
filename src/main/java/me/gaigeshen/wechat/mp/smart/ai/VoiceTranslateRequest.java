package me.gaigeshen.wechat.mp.smart.ai;

import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.UploadItem;

/**
 * 语音翻译
 *
 * @author gaigeshen
 */
public class VoiceTranslateRequest implements Request<VoiceTranslateResponse>, UploadItem {
  private String lfrom;
  private String lto;
  private UploadItem item;

  private VoiceTranslateRequest(String lfrom, String lto, UploadItem item) {
    this.lfrom = lfrom;
    this.lto = lto;
    this.item = item;
  }

  public static VoiceTranslateRequest create(String lfrom, String lto, UploadItem item) {
    return new VoiceTranslateRequest(lfrom, lto, item);
  }

  @Override
  public String requestUri() {
    return "http://api.weixin.qq.com/cgi-bin/media/voice/translatecontent?access_token=ACCESS_TOKEN&lfrom=xxx&lto=xxx";
  }
  @Override
  public String getFilename() {
    return item.getFilename();
  }
  @Override
  public byte[] getContent() {
    return item.getContent();
  }
}
