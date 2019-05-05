package me.gaigeshen.wechat.mp.sendall.comment;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 打开已群发文章评论
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CommentCloseRequest implements Request<CommentCloseResponse> {
  @JSONField(name = "msg_data_id") private long msgDataId;
  @JSONField(name = "index") private int index; // 多图文时，用来指定第几篇图文，从零开始
  @Override
  public Class<CommentCloseResponse> responseType() {
    return CommentCloseResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/comment/close?access_token=ACCESS_TOKEN";
  }
}
