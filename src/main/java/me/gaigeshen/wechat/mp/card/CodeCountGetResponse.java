package me.gaigeshen.wechat.mp.card;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查询导入卡券码的数量结果
 *
 * @author gaigeshen
 */
@Getter
public class CodeCountGetResponse extends AbstractResponse {
  private Integer count;
}
