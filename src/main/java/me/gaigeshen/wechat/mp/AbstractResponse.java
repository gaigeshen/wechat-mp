package me.gaigeshen.wechat.mp;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 抽象请求结果
 *
 * @author gaigeshen
 */
public abstract class AbstractResponse implements Response {
  private static final int SUCCEEDED_CODE = 0;

  @JSONField(name = "errcode") private Integer errorCode;
  @JSONField(name = "errmsg") private String errorMessage;

  @Override
  public boolean isSucceeded() {
    return errorCode == null || errorCode == SUCCEEDED_CODE;
  }
  @Override
  public String getErrorMessage() {
    return errorMessage;
  }

  public Integer getErrorCode() {
    return errorCode;
  }
}
