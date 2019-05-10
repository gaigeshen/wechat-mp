package me.gaigeshen.wechat.mp.smart.ocr;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 驾驶证识别结果
 *
 * @author gaigeshen
 */
@Getter
public class DrivingCardReadResponse extends AbstractResponse {
  @JSONField(name = "plate_num") private String plateNum;
  @JSONField(name = "vehicle_type") private String vehicleType;
  @JSONField(name = "owner") private String owner;
  @JSONField(name = "addr") private String addr;
  @JSONField(name = "use_character") private String useCharacter;
  @JSONField(name = "model") private String model;
  @JSONField(name = "vin") private String vin;
  @JSONField(name = "engine_num") private String engineNum;
  @JSONField(name = "register_date") private String registerDate;
  @JSONField(name = "issue_date") private String issueDate;
  @JSONField(name = "plate_num_b") private String plateNumB;
  @JSONField(name = "record") private String record;
  @JSONField(name = "passengers_num") private String passengersNum;
  @JSONField(name = "total_quality") private String totalQuality;
  @JSONField(name = "prepare_quality") private String prepareQuality;
}
