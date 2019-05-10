package me.gaigeshen.wechat.mp.smart.ai;

import me.gaigeshen.wechat.mp.EmptyDataResponse;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.UploadItem;

/**
 * 提交语音，语音转文字
 *
 * @author gaigeshen
 */
public class VoiceToTextRequest implements Request<EmptyDataResponse>, UploadItem {

  private String format;
  private String voiceId;
  private String lang;
  private UploadItem item;

  private VoiceToTextRequest(String format, String voiceId, String lang, UploadItem item) {
    this.format = format;
    this.voiceId = voiceId;
    this.lang = lang;
    this.item = item;
  }

  public static VoiceToTextRequest create(String lang, UploadItem item) {
    return new VoiceToTextRequest("mp3", "item", lang, item);
  }

  @Override
  public String requestUri() {
    return "http://api.weixin.qq.com/cgi-bin/media/voice/addvoicetorecofortext?access_token=ACCESS_TOKEN" +
            "&format=" + format + "&voice_id=" + voiceId + "&lang=" + lang;
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
