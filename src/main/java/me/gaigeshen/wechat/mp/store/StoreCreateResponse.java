package me.gaigeshen.wechat.mp.store;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 创建门店结果
 *
 * @author gaigeshen
 */
@Getter
public class StoreCreateResponse extends AbstractResponse {
  @JSONField(name = "poi_id")
  private Long poiId;
}
