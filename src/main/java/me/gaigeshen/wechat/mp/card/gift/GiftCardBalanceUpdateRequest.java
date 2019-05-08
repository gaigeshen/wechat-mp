package me.gaigeshen.wechat.mp.card.gift;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;

/**
 * 更新用户礼品卡信息
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class GiftCardBalanceUpdateRequest implements Request<GiftCardBalanceUpdateResponse> {
  @JSONField(name = "code") private String code;
  @JSONField(name = "card_id") private String cardId;
  @JSONField(name = "background_pic_url") private String backgroundPicUrl;
  @JSONField(name = "record_balance") private String recordBalance;
  @JSONField(name = "balance") private Integer balance;
  @JSONField(name = "custom_field_value1") private String customFieldValue1;
  @JSONField(name = "custom_field_value2") private String customFieldValue2;
  @JSONField(name = "custom_field_value3") private String customFieldValue3;
  @JSONField(name = "can_give_friend") private Boolean canGiveFriend;
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/card/generalcard/updateuser?access_token=ACCESS_TOKEN";
  }
}
