package me.gaigeshen.wechat.mp.message;

import me.gaigeshen.wechat.mp.message.eventpush.*;

/**
 * @author gaigeshen
 */
public enum MessageTypeDeclarer {

  EVENT_CLICK("CLICK", ClickEventMessage.class),
  EVENT_LOCATION("LOCATION", LocationEventMessage.class),
  EVENT_SCAN("SCAN", ScanEventMessage.class),
  EVENT_SUBSCRIBE("subscribe", SubscribeEventMessage.class),
  EVENT_UNSUBSCRIBE("unsubscribe", UnsubscribeEventMessage.class),
  EVENT_VIEW("VIEW", ViewEventMessage.class),

  TEXT("text", TextMessage.class),
  IMAGE("image", ImageMessage.class),
  VOICE("voice", VoiceMessage.class),
  VIDEO("video", VideoMessage.class),
  SHORT_VIDEO("shortvideo", ShortVideoMessage.class),
  LOCATION("location", LocationMessage.class),
  LINK("link", LinkMessage.class);

  // 注意类型名称不能重复
  private String typeName;
  // 类型名称对应的消息类型
  private Class<? extends Message> messageClass;

  MessageTypeDeclarer(String typeName, Class<? extends Message> messageClass) {
    this.typeName = typeName;
    this.messageClass = messageClass;
  }

  public static Class<? extends Message> messageClassFromName(String typeName) {
    return parseFromName(typeName).getMessageClass();
  }

  public static MessageTypeDeclarer parseFromName(String typeName) {
    for (MessageTypeDeclarer declarer : MessageTypeDeclarer.values()) {
      if (declarer.getTypeName().equals(typeName)) {
        return declarer;
      }
    }
    throw new IllegalArgumentException("Invalid type name");
  }

  public String getTypeName() {
    return typeName;
  }

  public Class<? extends Message> getMessageClass() {
    return messageClass;
  }
}
