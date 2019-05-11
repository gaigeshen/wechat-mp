package me.gaigeshen.wechat.mp.shakearound.redpack;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 创建红包活动结果
 *
 * @author gaigeshen
 */
@Getter
public class RedpackActivityCreateResponse extends AbstractResponse {
  @JSONField(name = "lottery_id")
  private String lotteryId;
  @JSONField(name = "page_id")
  private Long pageId;
}
