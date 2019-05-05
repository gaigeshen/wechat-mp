package me.gaigeshen.wechat.mp.material;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Builder;

/**
 * 图文消息素材
 *
 * @author gaigeshen
 */
@Builder
public class News {
  @JSONField(name = "thumb_media_id")
  private String thumbMediaId; // 图文消息缩略图的媒体编号

  private String author; // 图文消息的作者
  private String title; // 图文消息的标题

  @JSONField(name = "content_source_url")
  private String contentSourceUrl; // 阅读原文的页面

  // 小程序卡片跳转小程序
  // <mp-miniprogram data-miniprogram-appid="wx123123123"
  // data-miniprogram-path="pages/index/index"
  // data-miniprogram-title="小程序示例"
  // data-progarm-imageurl="http://mmbizqbic.cn/demo.jpg"></mp-miniprogram>

  // 文字跳转小程序
  // <p><a data-miniprogram-appid="wx123123123" data-miniprogram-path="pages/index" href="">点击文字跳转小程序</a></p>

  // 图片跳转小程序
  // <p><a data-miniprogram-appid="wx123123123" data-miniprogram-path="pages/index" href="">
  // <img src="http://mmbiz.qpic.cn/mmbiz_jpg/demo/0?wx_fmt=jpg" alt="" data-width="null" data-ratio="NaN"></a></p>
  private String content; // 图文消息页面的内容，如需插入小程序卡片，内容见以上备注

  private String digest; // 图文消息的描述，如本字段为空，则默认抓取正文前64个字

  // 以下三个字段只能取值：
  // 1. 是
  // 2. 否

  @JSONField(name = "show_cover_pic")
  private int showCoverPic; // 是否显示封面
  @JSONField(name = "need_open_comment")
  private int needOpenComment; // 是否打开评论
  @JSONField(name = "only_fans_can_comment")
  private int onlyFansCanComment; // 是否粉丝才可评论
}
