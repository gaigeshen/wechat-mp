package me.gaigeshen.wechat.mp.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 修改卡券结果
 *
 * @author gaigeshen
 */
@Getter
public class CardUpdateResponse extends AbstractResponse {
  @JSONField(name = "send_check")
  private Boolean sendChedk;
}
