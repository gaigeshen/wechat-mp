package me.gaigeshen.wechat.mp.sendall.comment;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 查看指定文章的评论数据结果
 *
 * @author gaigeshen
 */
@Getter
public class CommentListResponse extends AbstractResponse {
  @JSONField(name = "total") private Long total;
  @JSONField(name = "comment") private Comment[] comments;

  public static class Comment {
    @JSONField(name = "user_comment_id") private String userCommentId; // 用户评论编号
    @JSONField(name = "openid") private String openid;  // 用户编号
    @JSONField(name = "create_time") private String createTime; // 评论时间
    @JSONField(name = "content") private String content; // 评论内容
    @JSONField(name = "comment_type") private String commentType; // 是否精选
    @JSONField(name = "reply") private CommentReply commentReply; // 是否精选
  }

  public static class CommentReply {
    @JSONField(name = "content") private String content; // 作者回复内容
    @JSONField(name = "create_time") private String createTime; // 回复时间
  }
}
