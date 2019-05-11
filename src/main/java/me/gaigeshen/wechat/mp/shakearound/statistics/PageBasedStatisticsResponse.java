package me.gaigeshen.wechat.mp.shakearound.statistics;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 以页面为维度的数据统计结果
 *
 * @author gaigeshen
 */
@Getter
public class PageBasedStatisticsResponse extends AbstractResponse {

  private Data[] data;

  @Getter
  public static class Data {
    @JSONField(name = "click_pv") private Long clickPv;
    @JSONField(name = "click_uv") private Long clickUv;
    @JSONField(name = "ftime") private Long ftime;
    @JSONField(name = "shake_pv") private Long shakePv;
    @JSONField(name = "shake_uv") private Long shakeUv;
  }
}
