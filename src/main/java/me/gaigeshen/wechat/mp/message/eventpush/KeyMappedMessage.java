package me.gaigeshen.wechat.mp.message.eventpush;

import me.gaigeshen.wechat.mp.message.Message;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * 所有未定义的消息类型都是此类型，内部采用映射数据结构来表达所有的消息数据。
 * 注意所有的消息数据都是字符串类型，使用者自己转换成相应的数据类型。
 *
 * @author gaigeshen
 */
public class KeyMappedMessage implements Message, Map<String, Object> {
  private final Map<String, Object> map;
  public KeyMappedMessage() { this.map = new HashMap<>(); }

  @Override
  public int size() { return map.size(); }
  @Override
  public boolean isEmpty() { return map.isEmpty(); }
  @Override
  public boolean containsKey(Object key) { return map.containsKey(key); }
  @Override
  public boolean containsValue(Object value) { return map.containsValue(value); }
  @Override
  public Object get(Object key) { return map.get(key); }
  @Override
  public Object put(String key, Object value) { return map.put(key, value); }
  @Override
  public Object remove(Object key) { return map.remove(key); }
  @Override
  public void putAll(Map<? extends String, ?> m) { map.putAll(m); }
  @Override
  public void clear() { map.clear(); }
  @Override
  public Set<String> keySet() { return map.keySet(); }
  @Override
  public Collection<Object> values() { return map.values(); }
  @Override
  public Set<Entry<String, Object>> entrySet() { return map.entrySet(); }
  @Override
  public String toString() { return map.toString(); }

  @Override
  public String getToUserName() {
    return (String) get("ToUserName");
  }
  @Override
  public String getFromUserName() {
    return (String) get("FromUserName");
  }
  @Override
  public Long getCreateTime() {
    String createTime = (String) get("CreateTime");
    if (createTime != null) {
      return Long.valueOf(createTime);
    }
    return null;
  }
  @Override
  public String getMsgType() {
    return (String) get("MsgType");
  }
  @Override
  public Long getMsgId() {
    String msgId = (String) get("MsgId");
    if (msgId != null) {
      return Long.valueOf(msgId);
    }
    return null;
  }
}
