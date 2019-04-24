package me.gaigeshen.wechat.mp.message;

import lombok.Getter;

/**
 * 消息
 *
 * @author gaigeshen
 */
@Getter
public abstract class AbstractMessage {

  private static final String MSG_TYPE_TEXT = "text";
  private static final String MSG_TYPE_IMAGE = "image";
  private static final String MSG_TYPE_VOICE = "voice";
  private static final String MSG_TYPE_VIDEO = "video";
  private static final String MSG_TYPE_SHORT_VIDEO = "shortvideo";
  private static final String MSG_TYPE_LOCATION = "location";
  private static final String MSG_TYPE_LINK = "link";

  private String toUserName;
  private String fromUserName;
  private Long createTiime;
  private String msgType;
  private Long msgId;
}
