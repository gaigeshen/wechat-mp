package me.gaigeshen.wechat.mp.commons;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;

/**
 * Field based json utils
 *
 * @author gaigeshen
 */
public final class JsonUtils {
  private static final SerializeConfig SERIALIZE_CONFIG = new SerializeConfig(true);
  private static final ParserConfig PARSER_CONFIG = new ParserConfig(true);

  private JsonUtils() {}

  public static String toJson(Object data) {
    return JSON.toJSONString(data, SERIALIZE_CONFIG);
  }
  public static <T> T fromJson(String json, Class<T> type) {
    return JSON.parseObject(json, type, PARSER_CONFIG);
  }
}
