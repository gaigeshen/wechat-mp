package me.gaigeshen.wechat.mp.store.miniapp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取门店小程序类目结果
 *
 * @author gaigeshen
 */
@Getter
public class StoreMiniappCategoryResponse extends AbstractResponse {

  @JSONField(name = "data")
  private Data data;

  @Getter
  public static class Data {
    @JSONField(name = "all_category_info") private Categories categories;
  }
  @Getter
  public static class Categories {
    @JSONField(name = "categories") private Category[] categories;
  }
  @Getter
  public static class Category {
    @JSONField(name = "id") private Long id;
    @JSONField(name = "name") private String name;
    @JSONField(name = "level") private Integer level;
    @JSONField(name = "father") private Integer father;
    @JSONField(name = "children") private Long[] children;
    @JSONField(name = "scene") private Integer scene;
    @JSONField(name = "sensitive_type") private Integer sensitiveType;
    @JSONField(name = "qualify") private Qualify qualify;
  }
  @Getter
  public static class Qualify {
    @JSONField(name = "exter_list") private Exter[] exters;
  }
  @Getter
  public static class Exter {
    @JSONField(name = "inner_list") private Inner[] inners;
  }
  @Getter
  public static class Inner {
    @JSONField(name = "name") private String name;
  }
}
