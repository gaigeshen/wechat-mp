package me.gaigeshen.wechat.mp.sendall.comment;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;
import lombok.Getter;
import me.gaigeshen.wechat.mp.Request;
import me.gaigeshen.wechat.mp.commons.HttpMethod;

/**
 * 查看指定文章的评论数据
 *
 * @author gaigeshen
 */
@Getter
@Builder
public class CommentListRequest implements Request<CommentListResponse> {
  @JSONField(name = "msg_data_id") private long msgDataId;
  @JSONField(name = "index") private int index; // 多图文时，用来指定第几篇图文，从零开始
  @JSONField(name = "begin") private int begin; // 起始位置
  @JSONField(name = "count") private int count; // 获取数目，不能大于五十
  @JSONField(name = "type") private int type; // 评论类型，0-所有，1-普通，2-精选
  @Override
  public Class<CommentListResponse> responseType() {
    return CommentListResponse.class;
  }
  @Override
  public HttpMethod httpMethod() {
    return HttpMethod.POST;
  }
  @Override
  public String requestUri() {
    return "https://api.weixin.qq.com/cgi-bin/comment/list?access_token=ACCESS_TOKEN";
  }
}
