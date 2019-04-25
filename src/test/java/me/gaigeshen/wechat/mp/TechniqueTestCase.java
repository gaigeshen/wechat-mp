package me.gaigeshen.wechat.mp;

import me.gaigeshen.wechat.mp.message.MessageBodyCodecProcessor;
import org.junit.Test;

/**
 * @author gaigeshen
 */
public class TechniqueTestCase {


  @Test
  public void MessageBodyCodecProcessor() { // 测试消息体加解密处理器
    String encodingAesKey = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";
    String token = "pamtest";
    String appid = "wxb11529c136998cb6";
    String replyMessage = "<xml><ToUserName><![CDATA[oia2TjjewbmiOUlr6X-1crbLOvLw]]></ToUserName><FromUserName><![CDATA[gh_7f083739789a]]></FromUserName><CreateTime>1407743423</CreateTime><MsgType><![CDATA[video]]></MsgType><Video><MediaId><![CDATA[eYJ1MbwPRJtOvIEabaxHs7TX2D-HV71s79GUxqdUkjm6Gs2Ed1KF3ulAOA9H1xG0]]></MediaId><Title><![CDATA[testCallBackReplyVideo]]></Title><Description><![CDATA[testCallBackReplyVideo]]></Description></Video></xml>";

    MessageBodyCodecProcessor processor = new MessageBodyCodecProcessor(
            Config.builder().appid(appid).token(token).encodingAesKey(encodingAesKey).build());

    String encrypted = processor.encrypt(replyMessage);
    System.out.println(encrypted);


    String decrypted = processor.decrypt(encrypted, true);
    System.out.println(decrypted);
    System.out.println(decrypted.equals(replyMessage));
  }
}
