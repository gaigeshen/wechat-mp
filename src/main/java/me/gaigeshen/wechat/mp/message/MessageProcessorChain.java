package me.gaigeshen.wechat.mp.message;

import java.io.IOException;

/**
 * @author gaigeshen
 */
public interface MessageProcessorChain {

  void doProcess(Message message, ReplyMessageResponse response) throws IOException;

}
