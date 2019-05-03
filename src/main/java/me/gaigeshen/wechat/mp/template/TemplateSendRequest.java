package me.gaigeshen.wechat.mp.template;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import me.gaigeshen.wechat.mp.commons.MapBuilder;
import org.apache.commons.lang3.Validate;

import java.util.HashMap;
import java.util.Map;

/**
 * 发送模板消息
 *
 * @author gaigeshen
 */
public class TemplateSendRequest implements Request<TemplateSendResponse> {

  @JSONField(name = "touser")
  private String user;
  @JSONField(name = "template_id")
  private String templateId;
  @JSONField(name = "url")
  private String url;

  @JSONField(name = "miniprogram")
  private Map<String, Object> miniprogram;
  @JSONField(name = "data")
  private Map<String, Object> data;

  private TemplateSendRequest() {}

  /**
   * 创建发送模板消息的请求
   *
   * @param user 用户编号，即微信编号（openid）
   * @param templateId 模板编号
   * @return 发送模板消息请求
   */
  public static TemplateSendRequest create(String user, String templateId) {
    Validate.notBlank(user, "user is required");
    Validate.notBlank(templateId, "templateId is required");
    TemplateSendRequest request = new TemplateSendRequest();
    request.user = user;
    request.templateId = templateId;
    return request;
  }

  public TemplateSendRequest miniprogram(String appid, String pagePath) {
    Validate.notBlank(appid, "appid is required");
    this.miniprogram = MapBuilder.builder(2).put("appid", appid).put("pagepath", pagePath).build();
    return this;
  }

  public TemplateSendRequest data(String key, String value, String color) {
    if (this.data == null) {
      this.data = new HashMap<>();
    }
    this.data.put(key, MapBuilder.builder(2).put("value", value).put("color", color).build());
    return this;
  }

  public TemplateSendRequest data(String key, String value) {
    if (this.data == null) {
      this.data = new HashMap<>();
    }
    this.data.put(key, MapBuilder.builder(1).put("value", value).build());
    return this;
  }

  @Override
  public Class<TemplateSendResponse> responseType() {
    return TemplateSendResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
  }
}
