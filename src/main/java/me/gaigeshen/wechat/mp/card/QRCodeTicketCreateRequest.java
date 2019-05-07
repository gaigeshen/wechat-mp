package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;
import me.gaigeshen.wechat.mp.commons.MapBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 二维码创建请求
 *
 * @author gaigeshen
 */
public class QRCodeTicketCreateRequest implements Request<QRCodeTicketCreateResponse> {

  @JSONField(name = "action_name") private String actionName;
  @JSONField(name = "expire_seconds") private Long expireSeconds;
  @JSONField(name = "action_info") private Map<String, Object> actionInfo;

  private QRCodeTicketCreateRequest(String actionName, Long expireSeconds, Map<String, Object> actionInfo) {
    this.actionName = actionName;
    this.expireSeconds = expireSeconds;
    this.actionInfo = actionInfo;
  }

  /**
   * 创建二维码创建请求，设置扫描二维码领取单张卡券
   *
   * @param expireSeconds 有效时长，单位秒，限制在一分钟以上半小时内。可不传递该参数，默认365天
   * @param cardId 卡券编号
   * @param code 卡券码，自定义码的卡券必须填写
   * @param openid 指定领取者的用户编号，只有该用户可领取，绑定用户编号的卡券必须填写
   * @param isUniqueCode 指定下发二维码，生成的二维码随机分配一个码，领取后不可再次扫描。可不传递该参数。
   * @param outerStr 领取场景值，领取事件推送。 对于会员卡的二维码，用户每次扫码打开会员卡后点击任何链接，会将该值带入。
   * @return 二维码创建请求
   */
  public static QRCodeTicketCreateRequest create(Long expireSeconds, String cardId, String code, String openid, Boolean isUniqueCode, String outerStr) {
    return new QRCodeTicketCreateRequest("QR_CARD", expireSeconds,
            MapBuilder.builder()
                    .put("card", MapBuilder.builder()
                            .put("card_id", cardId)
                            .put("code", code)
                            .put("openid", openid)
                            .put("is_unique_code", isUniqueCode)
                            .put("outer_str", outerStr)
                            .build())
                    .build());
  }

  /**
   * 创建二维码创建请求，设置扫描二维码领取多张卡券
   *
   * @param cardId 卡券编号
   * @param code 卡券码，自定义码的卡券必须填写
   * @param outerStr 领取场景值，领取事件推送。 对于会员卡的二维码，用户每次扫码打开会员卡后点击任何链接，会将该值带入。
   * @return 二维码创建请求
   */
  public static QRCodeTicketCreateRequest createForMultiple(String cardId, String code, String outerStr) {
    List<Map<String, Object>> cards = new ArrayList<>();
    cards.add(MapBuilder.builder(1).put("card_id", cardId).put("code", code).put("outer_str", outerStr).build());
    return new QRCodeTicketCreateRequest("QR_MULTIPLE_CARD", null,
            MapBuilder.builder()
                    .put("multiple_card", MapBuilder.builder(1)
                            .put("card_list", cards)
                            .build())
                    .build());
  }

  /**
   * 在当前的请求基础上再次添加新的卡券，领取单张卡券的二维码创建请求调用此方法无效
   *
   * @param cardId 卡券编号
   * @param code 卡券码，自定义码的卡券必须填写
   * @param outerStr 领取场景值，领取事件推送。 对于会员卡的二维码，用户每次扫码打开会员卡后点击任何链接，会将该值带入。
   * @return 当前请求
   */
  @SuppressWarnings("unchecked")
  public QRCodeTicketCreateRequest addCard(String cardId, String code, String outerStr) {
    Map<?, ?> cards = (Map<?, ?>) actionInfo.get("multiple_card");
    if (cards != null) {
      List<Map<?, ?>> cardList = (List<Map<?, ?>>) cards.get("card_list");
      if (cardList != null) {
        cardList.add(MapBuilder.builder(1).put("card_id", cardId).put("code", code).put("outer_str", outerStr).build());
      }
    }
    return this;
  }

  @Override
  public Class<QRCodeTicketCreateResponse> responseType() {
    return QRCodeTicketCreateResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/qrcode/create?access_token=TOKEN";
  }
}
