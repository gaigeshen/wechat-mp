package me.gaigeshen.wechat.mp.sendall.comment;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 将评论标记精选
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CommentMarkelectRequest implements Request<CommentMarkelectResponse> {
  @JSONField(name = "msg_data_id") private long msgDataId;
  @JSONField(name = "index") private int index; // 多图文时，用来指定第几篇图文，从零开始
  @JSONField(name = "user_comment_id") private String userCommentId; // 用户评论编号
  @Override
  public Class<CommentMarkelectResponse> responseType() {
    return CommentMarkelectResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/comment/markelect?access_token=ACCESS_TOKEN";
  }
}
