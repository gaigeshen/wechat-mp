wx.config({
    debug: true,
    appId: '',
    timestamp: 0,
    nonceStr: '',
    signature: '',
    jsApiList: []
});

wx.ready(function(){
    wx.updateAppMessageShareData({ // 分享给朋友
        title: '',
        desc: '',
        link: '',
        imgUrl: '',
        success: function () {
        }
    });
    wx.updateTimelineShareData({ // 分享到朋友圈
        title: '',
        link: '',
        imgUrl: '',
        success: function () {
        }
    });
    wx.onMenuShareWeibo({ // 分享到腾讯微博
        title: '',
        desc: '',
        link: '',
        imgUrl: '',
        success: function () {
        },
        cancel: function () {
        }
    });
    wx.onMenuShareQZone({ // 分享到qq空间
        title: '',
        desc: '',
        link: '',
        imgUrl: '',
        success: function () {
        },
        cancel: function () {
        }
    });
});

wx.error(function(res){

});

wx.checkJsApi({
    jsApiList: ['chooseImage'],
    success: function(res) {
        // {"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
    }
});
// 接口列表
// updateAppMessageShareData
// updateTimelineShareData
// onMenuShareWeibo
// onMenuShareQZone
// startRecord
// stopRecord
// onVoiceRecordEnd
// playVoice
// pauseVoice
// stopVoice
// onVoicePlayEnd
// uploadVoice
// downloadVoice
// chooseImage
// previewImage
// uploadImage
// downloadImage
// translateVoice
// getNetworkType
// openLocation
// getLocation
// hideOptionMenu
// showOptionMenu
// hideMenuItems
// showMenuItems
// hideAllNonBaseMenuItem
// showAllNonBaseMenuItem
// closeWindow
// scanQRCode
// chooseWXPay
// openProductSpecificView
// addCard
// chooseCard
// openCard

// ==================== 图片接口

wx.chooseImage({ // 拍照或从手机相册中选图接口
    count: 1, // 默认9
    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
    success: function (res) {
        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
    }
});
wx.previewImage({ // 预览图片接口
    current: '', // 当前显示图片的http链接
    urls: [] // 需要预览的图片http链接列表
});
wx.uploadImage({ // 上传图片接口，上传图片有效期3天，可用微信多媒体接口下载图片到自己的服务器，此处获得的 serverId 即 media_id。
    localId: '', // 需要上传的图片的本地ID，由chooseImage接口获得
    isShowProgressTips: 1, // 默认为1，显示进度提示
    success: function (res) {
        var serverId = res.serverId; // 返回图片的服务器端ID
    }
});
wx.downloadImage({ // 下载图片接口
    serverId: '', // 需要下载的图片的服务器端ID，由uploadImage接口获得
    isShowProgressTips: 1, // 默认为1，显示进度提示
    success: function (res) {
        var localId = res.localId; // 返回图片下载后的本地ID
    }
});
wx.getLocalImgData({ // 获取本地图片接口
    localId: '', // 图片的localID
    success: function (res) {
        var localData = res.localData; // localData是图片的base64数据，可以用img标签显示
    }
});

// ==================== 音频接口

wx.startRecord(); // 开始录音接口
wx.stopRecord({ // 停止录音接口
    success: function (res) {
        var localId = res.localId;
    }
});
wx.onVoiceRecordEnd({ // 监听录音自动停止接口
    // 录音时间超过一分钟没有停止的时候会执行 complete 回调
    complete: function (res) {
        var localId = res.localId;
    }
});
wx.playVoice({ // 播放语音接口
    localId: '' // 需要播放的音频的本地ID，由stopRecord接口获得
});
wx.pauseVoice({ // 暂停播放接口
    localId: '' // 需要暂停的音频的本地ID，由stopRecord接口获得
});
wx.stopVoice({ // 停止播放接口
    localId: '' // 需要停止的音频的本地ID，由stopRecord接口获得
});
wx.onVoicePlayEnd({ // 监听语音播放完毕接口
    success: function (res) {
        var localId = res.localId; // 返回音频的本地ID
    }
});
wx.uploadVoice({ // 上传语音接口，上传语音有效期3天，可用微信多媒体接口下载语音到自己的服务器，此处获得的 serverId 即 media_id
    localId: '', // 需要上传的音频的本地ID，由stopRecord接口获得
    isShowProgressTips: 1, // 默认为1，显示进度提示
    success: function (res) {
        var serverId = res.serverId; // 返回音频的服务器端ID
    }
});
wx.downloadVoice({ // 下载语音接口
    serverId: '', // 需要下载的音频的服务器端ID，由uploadVoice接口获得
    isShowProgressTips: 1, // 默认为1，显示进度提示
    success: function (res) {
        var localId = res.localId; // 返回音频的本地ID
    }
});

// ==================== 智能接口

wx.translateVoice({ // 识别音频并返回识别结果接口
    localId: '', // 需要识别的音频的本地Id，由录音相关接口获得
    isShowProgressTips: 1, // 默认为1，显示进度提示
    success: function (res) {
        alert(res.translateResult); // 语音识别的结果
    }
});

// ==================== 设备信息

wx.getNetworkType({ // 获取网络状态接口
    success: function (res) {
        var networkType = res.networkType; // 返回网络类型2g，3g，4g，wifi
    }
});

// ==================== 地理位置

wx.openLocation({ // 使用微信内置地图查看位置接口
    latitude: 0, // 纬度，浮点数，范围为90 ~ -90
    longitude: 0, // 经度，浮点数，范围为180 ~ -180。
    name: '', // 位置名
    address: '', // 地址详情说明
    scale: 1, // 地图缩放级别,整形值,范围从1~28。默认为最大
    infoUrl: '' // 在查看位置界面底部显示的超链接,可点击跳转
});
wx.getLocation({ // 获取地理位置接口
    type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
    success: function (res) {
        var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
        var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
        var speed = res.speed; // 速度，以米/每秒计
        var accuracy = res.accuracy; // 位置精度
    }
});

// ==================== 摇一摇周边

wx.startSearchBeacons({ // 开启查找周边ibeacon设备接口
    ticket:"",  //摇周边的业务ticket, 系统自动添加在摇出来的页面链接后面
    complete:function(argv){
    }
});
wx.stopSearchBeacons({ // 关闭查找周边ibeacon设备接口
    complete:function(res){
    }
});
wx.onSearchBeacons({ // 监听周边ibeacon设备接口
    complete:function(argv){
        //回调函数，可以数组形式取得该商家注册的在周边的相关设备列表
    }
});

// ==================== 界面操作

wx.closeWindow(); // 关闭当前网页窗口接口
wx.hideMenuItems({ // 批量隐藏功能按钮接口
    menuList: [] // 要隐藏的菜单项，只能隐藏“传播类”和“保护类”按钮
});
wx.showMenuItems({ // 批量显示功能按钮接口
    menuList: [] // 要显示的菜单项，所有menu项见附录3
});
wx.hideAllNonBaseMenuItem(); // 隐藏所有非基础按钮接口
wx.showAllNonBaseMenuItem(); // 显示所有功能按钮接口

// 基本类
// 举报: "menuItem:exposeArticle"
// 调整字体: "menuItem:setFont"
// 日间模式: "menuItem:dayMode"
// 夜间模式: "menuItem:nightMode"
// 刷新: "menuItem:refresh"
// 查看公众号（已添加）: "menuItem:profile"
// 查看公众号（未添加）: "menuItem:addContact"

// 传播类
// 发送给朋友: "menuItem:share:appMessage"
// 分享到朋友圈: "menuItem:share:timeline"
// 分享到QQ: "menuItem:share:qq"
// 分享到Weibo: "menuItem:share:weiboApp"
// 收藏: "menuItem:favorite"
// 分享到FB: "menuItem:share:facebook"
// 分享到 QQ 空间/menuItem:share:QZone
//
// 保护类
// 编辑标签: "menuItem:editTag"
// 删除: "menuItem:delete"
// 复制链接: "menuItem:copyUrl"
// 原网页: "menuItem:originPage"
// 阅读模式: "menuItem:readMode"
// 在QQ浏览器中打开: "menuItem:openWithQQBrowser"
// 在Safari中打开: "menuItem:openWithSafari"
// 邮件: "menuItem:share:email"
//
// 一些特殊公众号: "menuItem:share:brand"

// ==================== 微信扫一扫

wx.scanQRCode({ // 调起微信扫一扫接口
    needResult: 0, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
    scanType: ["qrCode","barCode"], // 可以指定扫二维码还是一维码，默认二者都有
    success: function (res) {
        var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
    }
});

// ==================== 微信小店

wx.openProductSpecificView({ // 跳转微信商品页接口
    productId: '', // 商品id
    viewType: '' // 0.默认值，普通商品详情页1.扫一扫商品详情页2.小店商品详情页
});

// ==================== 微信支付

wx.chooseWXPay({ // 发起一个微信支付请求
    timestamp: 0, // 支付签名时间戳
    nonceStr: '', // 支付签名随机串，不长于 32 位
    package: '', // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=\*\*\*）
    signType: '', // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
    paySign: '', // 支付签名
    success: function (res) {
    }
});

// ==================== 快速输入

wx.openAddress({ // 共享收货地址接口
    success: function (res) {
        var userName = res.userName; // 收货人姓名
        var postalCode = res.postalCode; // 邮编
        var provinceName = res.provinceName; // 国标收货地址第一级地址（省）
        var cityName = res.cityName; // 国标收货地址第二级地址（市）
        var countryName = res.countryName; // 国标收货地址第三级地址（国家）
        var detailInfo = res.detailInfo; // 详细收货地址信息
        var nationalCode = res.nationalCode; // 收货地址国家码
        var telNumber = res.telNumber; // 收货人手机号码
    }
});

// ==================== 卡券

wx.chooseCard({ // 拉取适用卡券列表并获取用户选择信息
    shopId: '', // 门店Id
    cardType: '', // 卡券类型
    cardId: '', // 卡券Id
    timestamp: 0, // 卡券签名时间戳
    nonceStr: '', // 卡券签名随机串
    signType: '', // 签名方式，默认'SHA1'
    cardSign: '', // 卡券签名
    success: function (res) {
        var cardList= res.cardList; // 用户选中的卡券列表信息
    }
});
wx.addCard({ // 批量添加卡券
    cardList: [{
        cardId: '',
        cardExt: ''
    }], // 需要添加的卡券列表
    success: function (res) {
        var cardList = res.cardList; // 添加的卡券列表信息
    }
});
wx.openCard({ // 查看微信卡包中的卡券接口
    cardList: [{
        cardId: '',
        code: ''
    }]// 需要打开的卡券列表
});