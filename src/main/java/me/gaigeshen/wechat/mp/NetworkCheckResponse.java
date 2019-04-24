package me.gaigeshen.wechat.mp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;

/**
 * 网络检测结果
 *
 * @author gaigeshen
 */
@Getter
public class NetworkCheckResponse extends AbstractResponse {
  private Dns[] dns;
  private Ping[] ping;
  @Getter
  public class Dns {
    @JSONField(name = "ip")
    private String ip;
    @JSONField(name = "real_operator")
    private String realOperator;
  }
  @Getter
  public class Ping {
    @JSONField(name = "ip")
    private String ip;
    @JSONField(name = "from_operator")
    private String fromOperator;
    @JSONField(name = "package_loss")
    private String packageLoss;
    @JSONField(name = "time")
    private String time;
  }
}
