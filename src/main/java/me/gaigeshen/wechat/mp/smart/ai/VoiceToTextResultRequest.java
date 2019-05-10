package me.gaigeshen.wechat.mp.smart.ai;

import me.gaigeshen.wechat.mp.Request;

/**
 * 语音转文字结果获取
 *
 * @author gaigeshen
 */
public class VoiceToTextResultRequest implements Request<VoiceToTextResultResponse> {

  private String voiceId;
  private String lang;

  public VoiceToTextResultRequest(String voiceId, String lang) {
    this.voiceId = voiceId;
    this.lang = lang;
  }

  public VoiceToTextResultRequest create(String voiceId, String lang) {
    return new VoiceToTextResultRequest(voiceId, lang);
  }

  @Override
  public String requestUri() {
    return "http://api.weixin.qq.com/cgi-bin/media/voice/queryrecoresultfortext?access_token=ACCESS_TOKEN&voice_id=" + voiceId + "&lang=" + lang;
  }
}
