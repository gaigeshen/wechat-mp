package me.gaigeshen.wechat.mp.sendall;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.Map;

/**
 * 群发消息
 *
 * @author gaigeshen
 */
public class MassMessageSendRequest implements Request<MassMessageSendResponse> {

  @JSONField(name = "msgtype")
  private String type; // 消息类型
  @JSONField(name = "send_ignore_reprint")
  private int sendIgnoreReprint; // 只有发送图文消息时才需要
  @JSONField(name = "clientmsgid")
  private String clientMsgId; // 群发消息编号
  @JSONField(name = "filter")
  private Filter filter; // 按标签发送
  @JSONField(name = "touser")
  private String[] users; // 按用户发送

  @JSONField(name = "mpnews")
  private Map<String, Object> news; // 图文消息才有值
  @JSONField(name = "text")
  private Map<String, Object> text; // 文本消息才有值
  @JSONField(name = "voice")
  private Map<String, Object> voice; // 语音消息才有值
  @JSONField(name = "image")
  private Map<String, Object> image; // 图片消息才有值
  @JSONField(name = "mpvideo")
  private Map<String, Object> video; // 视频消息才有值
  @JSONField(name = "wxcard")
  private Map<String, Object> card; // 卡券消息才有值

  private MassMessageSendRequest() {}

  /**
   * 设置群发消息编号，可以不设置，默认以群发范围和群发内容的摘要值
   *
   * @param msgId 消息编号
   * @return 当前的请发消息请求
   */
  public MassMessageSendRequest clientMsgId(String msgId) {
    this.clientMsgId = msgId;
    return this;
  }

  /**
   * 设置群发消息的筛选条件，如果此前已设置按用户发送，则调用此方法无效
   *
   * @param filter 筛选条件
   * @return 当前的群发消息请求
   */
  public MassMessageSendRequest filter(Filter filter) {
    if (users == null) {
      this.filter = filter;
    }
    return this;
  }

  /**
   * 设置群发消息的用户，如果此前已设置按标签筛选，则调用此方法无效
   *
   * @param users 用户集合
   * @return 当前的群发消息请求
   */
  public MassMessageSendRequest users(String[] users) {
    if (filter == null) {
      this.users = users;
    }
    return this;
  }

  public static MassMessageSendRequest createNews(String mediaId, boolean ignoreReprint) {
    MassMessageSendRequest message = new MassMessageSendRequest();
    message.type = "mpnews";
    if (ignoreReprint) {
      message.sendIgnoreReprint = 1;
    } else {
      message.sendIgnoreReprint = 0;
    }
    message.news = MapBuilder.builder(1).put("media_id", mediaId).build();
    return message;
  }

  public static MassMessageSendRequest createText(String content) {
    MassMessageSendRequest message = new MassMessageSendRequest();
    message.type = "text";
    message.text = MapBuilder.builder(1).put("content", content).build();
    return message;
  }

  public static MassMessageSendRequest createVoice(String mediaId) {
    MassMessageSendRequest message = new MassMessageSendRequest();
    message.type = "voice";
    message.voice = MapBuilder.builder(1).put("media_id", mediaId).build();
    return message;
  }

  public static MassMessageSendRequest createImage(String mediaId) {
    MassMessageSendRequest message = new MassMessageSendRequest();
    message.type = "image";
    message.image = MapBuilder.builder(1).put("media_id", mediaId).build();
    return message;
  }

  public static MassMessageSendRequest createVideo(String mediaId) {
    MassMessageSendRequest message = new MassMessageSendRequest();
    message.type = "mpvideo";
    message.video = MapBuilder.builder(1).put("media_id", mediaId).build();
    return message;
  }

  public static MassMessageSendRequest createCard(String cardId) {
    MassMessageSendRequest message = new MassMessageSendRequest();
    message.type = "wxcard";
    message.card = MapBuilder.builder(1).put("card_id", cardId).build();
    return message;
  }

  @Override
  public Class<MassMessageSendResponse> responseType() {
    return MassMessageSendResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";
  }
}
