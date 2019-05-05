package me.gaigeshen.wechat.mp.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取用户的标签列表结果
 *
 * @author gaigeshen
 */
@Getter
public class UserTagGetResponse extends AbstractResponse {
  @JSONField(name = "tagid_list")
  private Long[] tags;
}
