package me.gaigeshen.wechat.mp.store;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.MapBuilder;
import org.apache.commons.lang3.Validate;

import java.util.Map;

/**
 * 修改门店服务信息
 *
 * @author gaigeshen
 */
public class StoreUpdateResquest implements Request<StoreUpdateResponse> {

  @JSONField(name = "business")
  private Map<String, Object> business;

  private StoreUpdateResquest(Map<String, Object> business) {
    this.business = business;
  }

  public static StoreUpdateResquest create(BaseInfo baseInfo) {
    return new StoreUpdateResquest(MapBuilder.builder(1).put("base_info", baseInfo).build());
  }

  public static BaseInfo.BaseInfoBuilder baseInfoBuilder() {
    return BaseInfo.builder();
  }

  public static PhotoUrl[] createPhotoUrls(String[] urls) {
    Validate.notEmpty(urls, "Urls is required");
    PhotoUrl[] result = new PhotoUrl[urls.length];
    for (int i = 0; i < urls.length; i++) {
      result[i] = PhotoUrl.builder().photoUrl(urls[i]).build();
    }
    return result;
  }

  @Builder
  private static class BaseInfo {
    @JSONField(name = "poi_id ") private long poiId;
    @JSONField(name = "sid") private String sid;
    @JSONField(name = "telephone") private String telephone;
    @JSONField(name = "recommend") private String recommend;
    @JSONField(name = "special") private String special;
    @JSONField(name = "introduction") private String introduction;
    @JSONField(name = "open_time") private String openTime;
    @JSONField(name = "avg_price") private int avgPrice;
    @JSONField(name = "photo_list") private PhotoUrl[] photoUrls;
  }
  @Builder
  private static class PhotoUrl {
    @JSONField(name = "photo_url") private String photoUrl;
  }

  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/poi/updatepoi?access_token=ACCESS_TOKEN";
  }
}
