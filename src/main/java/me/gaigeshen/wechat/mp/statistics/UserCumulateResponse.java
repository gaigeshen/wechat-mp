package me.gaigeshen.wechat.mp.statistics;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取用户累计数据结果
 *
 * @author gaigeshen
 */
@Getter
public class UserCumulateResponse extends AbstractResponse {

  @JSONField(name = "list")
  private Item[] items;

  public static class Item {
    @JSONField(name = "ref_date") private String date; // 数据的日期
    @JSONField(name = "cumulate_user") private Long cumulateUser; // 总用户量
  }
}
