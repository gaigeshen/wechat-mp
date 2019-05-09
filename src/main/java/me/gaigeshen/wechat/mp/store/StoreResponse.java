package me.gaigeshen.wechat.mp.store;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询门店结果
 *
 * @author gaigeshen
 */
@Getter
public class StoreResponse extends AbstractResponse {
  @JSONField(name = "business")
  private Business business;

  @Getter
  public static class Business {
    @JSONField(name = "base_info") private BaseInfo baseInfo;
  }
  @Getter
  public static class BaseInfo {
    @JSONField(name = "sid") private String sid;
    @JSONField(name = "business_name") private String businessName;
    @JSONField(name = "branch_name") private String branchName;
    @JSONField(name = "province") private String province;
    @JSONField(name = "city") private String city;
    @JSONField(name = "district") private String district;
    @JSONField(name = "address") private String address;
    @JSONField(name = "telephone") private String telephone;
    @JSONField(name = "categories") private String[] categories;
    @JSONField(name = "offset_type") private int offsetType;
    @JSONField(name = "longitude") private double longitude;
    @JSONField(name = "latitude") private double latitude;
    @JSONField(name = "recommend") private String recommend;
    @JSONField(name = "special") private String special;
    @JSONField(name = "introduction") private String introduction;
    @JSONField(name = "open_time") private String openTime;
    @JSONField(name = "avg_price") private int avgPrice;
    @JSONField(name = "available_state") private int availableState;
    @JSONField(name = "update_status") private int updateStatus;
    @JSONField(name = "photo_list") private PhotoUrl[] photoUrls;
  }
  @Getter
  public static class PhotoUrl {
    @JSONField(name = "photo_url") private String photoUrl;
  }
}
