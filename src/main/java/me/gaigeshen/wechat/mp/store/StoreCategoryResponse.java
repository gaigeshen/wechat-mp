package me.gaigeshen.wechat.mp.store;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 门店类目表结果
 *
 * @author gaigeshen
 */
@Getter
public class StoreCategoryResponse extends AbstractResponse {
  @JSONField(name = "category_list")
  private String[] categories;
}
