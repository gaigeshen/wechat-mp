package me.gaigeshen.wechat.mp.message;

/**
 * 回复消息，如需扩展新的消息类型，请先参考现有的实现
 *
 * @author gaigeshen
 */
public interface ReplyMessage {
  /**
   * 文本消息类型
   */
  String MSG_TYPE_TEXT = "text";
  /**
   * 图片消息类型
   */
  String MSG_TYPE_IMAGE = "image";
  /**
   * 语音消息类型
   */
  String MSG_TYPE_VOICE = "voice";
  /**
   * 视频消息类型
   */
  String MSG_TYPE_VIDEO = "video";
  /**
   * 音乐消息类型
   */
  String MSG_TYPE_MUSIC = "music";
  /**
   * 图文消息类型
   */
  String MSG_TYPE_NEWS = "news";
}
