package me.gaigeshen.wechat.mp.card.gift;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 下架礼品卡货架结果
 *
 * @author gaigeshen
 */
@Getter
public class GiftCardLandingPageOffResponse extends AbstractResponse {

  @JSONField(name = "control_info")
  private ControlInfo controlInfo;

  @Getter
  public static class ControlInfo {
    @JSONField(name = "biz_control_type") private String bizControlType;
    @JSONField(name = "system_biz_control_type") private String systemBizControlType;
    @JSONField(name = "list") private ControlInfoData[] controlInfoData;
  }

  @Getter
  public static class ControlInfoData {
    @JSONField(name = "page_id") private String pageId;
    @JSONField(name = "page_control_type") private String pageControlType;
    @JSONField(name = "system_page_control_type") private String systemPageControlType;
  }
}
