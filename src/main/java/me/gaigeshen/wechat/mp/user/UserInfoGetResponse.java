package me.gaigeshen.wechat.mp.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 获取用户信息结果
 *
 * @author gaigeshen
 */
@Getter
public class UserInfoGetResponse extends AbstractResponse {
  private Integer subscribe; // 用户是否订阅该公众号标识，0-未关注
  private String openid; // 用户标识
  private String nickname; // 昵称
  private Integer sex; // 性别，1-男，2-女，0-未知
  private String language; // 语言
  private String city; // 城市
  private String province; // 省份
  private String country; // 国家
  @JSONField(name = "headimgurl") private String avatar; // 头像地址
  @JSONField(name = "subscribe_time") private Long subscribeTime; // 最后关注时间
  @JSONField(name = "unionid") private String unionId; // 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
  @JSONField(name = "remark") private String remark; // 备注
  @JSONField(name = "tagid_list") private Long[] tags; // 标签
  @JSONField(name = "subscribe_scene") private String subscribeScene; // 关注的渠道来源
  @JSONField(name = "qr_scene") private Long qrScene; // 二维码扫码场景（开发者自定义）
  @JSONField(name = "qr_scene_str") private String qrSceneStr; // 二维码扫码场景描述（开发者自定义）

  // 关注的渠道
  // ADD_SCENE_SEARCH 公众号搜索
  // ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移
  // ADD_SCENE_PROFILE_CARD 名片分享
  // ADD_SCENE_QR_CODE 扫描二维码
  // ADD_SCENEPROFILE 图文页内名称点击
  // ADD_SCENE_PROFILE_ITEM 图文页右上角菜单
  // ADD_SCENE_PAID 支付后关注
  // ADD_SCENE_OTHERS 其他
}
