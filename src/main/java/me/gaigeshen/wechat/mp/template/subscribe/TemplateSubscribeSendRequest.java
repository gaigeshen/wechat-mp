package me.gaigeshen.wechat.mp.template.subscribe;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import me.gaigeshen.wechat.mp.commons.MapBuilder;
import org.apache.commons.lang3.Validate;

import java.util.HashMap;
import java.util.Map;

/**
 * 订阅模板消息发送
 *
 * @author gaigeshen
 */
public class TemplateSubscribeSendRequest implements Request<TemplateSubscribeSendResponse> {

  @JSONField(name = "touser")
  private String user;
  @JSONField(name = "template_id")
  private String templateId;
  @JSONField(name = "url")
  private String url;
  @JSONField(name = "scene")
  private String scene;
  @JSONField(name = "title")
  private String title;

  @JSONField(name = "miniprogram")
  private Map<String, Object> miniprogram;
  @JSONField(name = "data")
  private Map<String, Object> data;

  private TemplateSubscribeSendRequest() {}

  /**
   * 创建订阅模板消息发送请求
   *
   * @param user 用户编号（openid）
   * @param templateId 模板编号
   * @param scene 场景值
   * @param title 消息标题
   * @param url 跳转的链接
   * @return 订阅模板消息发送请求
   */
  public static TemplateSubscribeSendRequest create(String user, String templateId, String scene, String title, String url) {
    Validate.notBlank(user, "user is required");
    Validate.notBlank(templateId,"templateId is required");
    Validate.notBlank(scene,"scene is required");
    Validate.notBlank(title,"title is required");
    TemplateSubscribeSendRequest request = new TemplateSubscribeSendRequest();
    request.user = user;
    request.templateId = templateId;
    request.scene = scene;
    request.title = title;
    request.url = url;
    return request;
  }

  public TemplateSubscribeSendRequest miniprogram(String appid, String pagePath) {
    Validate.notBlank(appid, "appid is required");
    this.miniprogram = MapBuilder.builder(2).put("appid", appid).put("pagepath", pagePath).build();
    return this;
  }

  public TemplateSubscribeSendRequest data(String value, String color) {
    if (this.data == null) {
      this.data = new HashMap<>(1);
    }
    this.data.put("content", MapBuilder.builder(2).put("value", value).put("color", color).build());
    return this;
  }

  @Override
  public Class<TemplateSubscribeSendResponse> responseType() {
    return TemplateSubscribeSendResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/message/template/subscribe?access_token=ACCESS_TOKEN";
  }
}
