package me.gaigeshen.wechat.mp.message.eventpush;

import lombok.Getter;

/**
 * 事件消息，某些事件推送在发生后，是允许开发者回复用户的，某些则不允许<br>
 * 1. 关注/取消关注事件<br>
 * 2. 扫描带参数二维码事件<br>
 * 3. 上报地理位置事件<br>
 * 4. 自定义菜单事件<br>
 * 5. 点击菜单拉取消息时的事件推送<br>
 * 6. 点击菜单跳转链接时的事件推送<br>
 *
 * @author gaigeshen
 */
@Getter
public abstract class AbstractEventMessage {

  private static final String EVT_TYPE_SUBSCRIBE = "subscribe";
  private static final String EVT_TYPE_SCAN = "SCAN";
  private static final String EVT_TYPE_LOCATION = "LOCATION";
  private static final String EVT_TYPE_CLICK = "CLICK";

  private String toUserName;    // 发给用户
  private String fromUserName;  // 来源用户
  private String createTime;    // 创建事件
  private String event;         // 事件类型
}
