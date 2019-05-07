package me.gaigeshen.wechat.mp.account;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.Map;

/**
 * 二维码票据创建
 *
 * @author gaigeshen
 */
public class QRCodeTicketCreateRequest implements Request<QRCodeTicketCreateResponse> {
  @JSONField(name = "expire_seconds") private Integer expireSeconds;
  @JSONField(name = "action_name") private String actionName;
  @JSONField(name = "action_info") private Map<String, Object> actionInfo;

  private QRCodeTicketCreateRequest(Integer expireSeconds, String actionName, Map<String, Object> actionInfo) {
    this.expireSeconds = expireSeconds;
    this.actionName = actionName;
    this.actionInfo = actionInfo;
  }

  /**
   * 创建临时二维码票据请求
   *
   * @param expireSeconds 过期时长单位秒
   * @param sceneId 场景值
   * @return 临时二维码票据请求
   */
  public static QRCodeTicketCreateRequest create(int expireSeconds, long sceneId) {
    return new QRCodeTicketCreateRequest(expireSeconds, "QR_SCENE",
            MapBuilder.builder(1).put("scene", MapBuilder.builder(1).put("scene_id", sceneId).build()).build());
  }

  /**
   * 创建临时二维码票据请求
   *
   * @param expireSeconds 过期时长单位秒
   * @param sceneStr 场景值
   * @return 临时二维码票据请求
   */
  public static QRCodeTicketCreateRequest create(int expireSeconds, String sceneStr) {
    return new QRCodeTicketCreateRequest(expireSeconds, "QR_STR_SCENE",
            MapBuilder.builder(1).put("scene", MapBuilder.builder(1).put("scene_str", sceneStr).build()).build());
  }

  /**
   * 创建临时二维码票据请求
   *
   * @param sceneId 场景值
   * @return 临时二维码票据请求
   */
  public static QRCodeTicketCreateRequest create(long sceneId) {
    return new QRCodeTicketCreateRequest(null, "QR_LIMIT_SCENE",
            MapBuilder.builder(1).put("scene", MapBuilder.builder(1).put("scene_id", sceneId).build()).build());
  }

  /**
   * 创建临时二维码票据请求
   *
   * @param sceneStr 场景值
   * @return 临时二维码票据请求
   */
  public static QRCodeTicketCreateRequest create(String sceneStr) {
    return new QRCodeTicketCreateRequest(null, "QR_LIMIT_STR_SCENE",
            MapBuilder.builder(1).put("scene", MapBuilder.builder(1).put("scene_str", sceneStr).build()).build());
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
  }
}
