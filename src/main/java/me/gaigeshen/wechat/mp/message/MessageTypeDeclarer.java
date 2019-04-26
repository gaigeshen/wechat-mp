package me.gaigeshen.wechat.mp.message;

/**
 * @author gaigeshen
 */
public enum MessageTypeDeclarer {
  TEXT("text", TextMessage.class),
  IMAGE("image", ImageMessage.class),
  VOICE("voice", VoiceMessage.class),
  VIDEO("video", VideoMessage.class),
  SHORT_VIDEO("shortvideo", ShortVideoMessage.class),
  LOCATION("location", LocationMessage.class),
  LINK("link", LinkMessage.class);

  private String typeName;
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
