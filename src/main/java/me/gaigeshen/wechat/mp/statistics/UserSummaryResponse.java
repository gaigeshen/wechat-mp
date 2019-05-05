package me.gaigeshen.wechat.mp.statistics;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取用户增减数据结果
 *
 * @author gaigeshen
 */
@Getter
public class UserSummaryResponse extends AbstractResponse {

  @JSONField(name = "list")
  private Item[] items;

  public static class Item {
    @JSONField(name = "ref_date") private String date; // 数据的日期
    @JSONField(name = "user_source") private Long userSource; // 用户的渠道
    @JSONField(name = "new_user") private Long newUser; // 新增的用户数量
    @JSONField(name = "cancel_user") private Long cancelUser; // 取消关注的用户数量
  }
}
