package me.gaigeshen.wechat.mp.shakearound;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * @author gaigeshen
 */
@Getter
public class ShakeAroundImageUploadResponse extends AbstractResponse {

  private Data data;

  @Getter
  public static class Data {
    @JSONField(name = "pic_url")
    private String picUrl;
  }
}
