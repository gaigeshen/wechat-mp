package me.gaigeshen.wechat.mp.message;

import java.io.IOException;

/**
 * @author gaigeshen
 */
public interface ReplyMessageResponse {

  void write(ReplyMessage message) throws IOException;

}
