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
  EVENT_CARD_PASS_CHECK("card_pass_check", CardPassCheckEventMessage.class),
  EVENT_USER_GET_CARD("user_get_card", CardGetByUserEventMessage.class),
  EVENT_USER_GIFTING_CARD("user_gifting_card", CardUserGiftingtEventMessage.class),
  EVENT_USER_DEL_CARD("user_del_card", CardDeletedEventMessage.class),
  EVENT_USER_CONSUME_CARD("user_consume_card", CardConsumedEventMessage.class),
  EVENT_USER_VIEW_CARD("user_view_card", CardViewByUserEventMessage.class),
  EVENT_USER_ENTER_SESSION_FROM_CARD("user_enter_session_from_card", CardUserEnterSessionEventMessage.class),
  EVENT_UPDATE_MEMBER_CARD("update_member_card", MemberCardUpdatedEventMessage.class),
  EVENT_CARD_SKU_REMIND("card_sku_remind", CardStockRemindEventMessage.class),
  EVENT_CARD_PAY_ORDER("card_pay_order", CardPayOrderEventMessage.class),
  EVENT_SUBMIT_MEMBERCARD_USER_INFO("submit_membercard_user_info", MemberCardSubmitUserInfoEventMessage.class),
  EVENT_GIFTCARD_PAY_DONE("giftcard_pay_done", GiftCardPayDoneEventMessage.class),
  EVENT_GIFTCARD_SEND_TO_FRIEND("giftcard_send_to_friend", GiftCardSendToFriendEventMessage.class),
  EVENT_GIFTCARD_USER_ACCEPT("giftcard_user_accept", GiftCardUserAcceptEventMessage.class),

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
