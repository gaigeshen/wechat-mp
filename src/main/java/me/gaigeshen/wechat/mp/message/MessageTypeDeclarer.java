package me.gaigeshen.wechat.mp.message;

import me.gaigeshen.wechat.mp.message.eventpush.*;

/**
 * 消息类型定义枚举，包含所有的消息类型，有普通消息和事件消息
 *
 * @author gaigeshen
 */
public enum MessageTypeDeclarer {

  EVENT_CLICK("CLICK", ClickEventMessage.class),
  EVENT_LOCATION("LOCATION", LocationEventMessage.class),
  EVENT_SCAN("SCAN", ScanEventMessage.class),
  EVENT_SUBSCRIBE("subscribe", SubscribeEventMessage.class),
  EVENT_UNSUBSCRIBE("unsubscribe", UnsubscribeEventMessage.class),
  EVENT_VIEW("VIEW", ViewEventMessage.class),
  EVENT_MASS_MESSAGE_RESULT("MASSSENDJOBFINISH", MassMessageResultEventMessage.class),
  EVENT_TEMPLATE_RESULT("TEMPLATESENDJOBFINISH", TemplateResultEventMessage.class),
  EVENT_QUALIFICATION_VERIFY_SUCCESS("qualification_verify_success", QualificationVerifySuccessEventMessage.class),
  EVENT_QUALIFICATION_VERIFY_FAIL("qualification_verify_fail", QualificationVerifyFailEventMessage.class),
  EVENT_NAMING_VERIFY_SUCCESS("naming_verify_success", NamingVerifySuccessEventMessage.class),
  EVENT_NAMING_VERIFY_FAIL("naming_verify_fail", NamingVerifyFailEventMessage.class),
  EVENT_ANNUAL_RENEW("annual_renew", AnnualRenewEventMessage.class),
  EVENT_VERIFY_EXPIRED("verify_expired", VerifyExpiredEventMessage.class),
  EVENT_POI_CHECK_NOTIFY("poi_check_notify", PoiCheckNotifyEventMessage.class),
  EVENT_USER_PAY_FROM_PAY_CELL("user_pay_from_pay_cell", UserPayFromPayCellEventMessage.class),

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
