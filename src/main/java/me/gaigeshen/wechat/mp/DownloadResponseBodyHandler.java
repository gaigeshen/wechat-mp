package me.gaigeshen.wechat.mp;

import me.gaigeshen.wechat.mp.commons.JsonUtils;

import java.util.function.Consumer;

/**
 * 下载文件请求结果处理器，泛型指定在下载文件失败的情况下要将结果转换为指定的类型的对象
 *
 * @author gaigeshen
 */
public abstract class DownloadResponseBodyHandler<R extends Response> implements ResponseBodyHandler {
  private final Class<R> failedResultType;
  private final Consumer<byte[]> contentConsumer;
  private R failedResult;

  /**
   * 创建下载文件请求结果处理器
   *
   * @param failedResultType 下载失败的时候的结果类型
   * @param contentConsumer 下载成功时，文件内容的消费者
   */
  public DownloadResponseBodyHandler(Class<R> failedResultType, Consumer<byte[]> contentConsumer) {
    if (failedResultType == null) {
      throw new IllegalArgumentException("failedResultType is required");
    }
    if (contentConsumer == null) {
      throw new IllegalArgumentException("contentConsumer is required");
    }
    this.failedResultType = failedResultType;
    this.contentConsumer = contentConsumer;
  }

  // 注意此处的逻辑处理
  // 如果内容类型不是文件类型的（ends with json, applicaton/json），则认为是下载文件失败
  // 当下载文件失败，尝试转换错误响应至指定的类型的对象
  @Override
  public void handle(String contentType, byte[] content) {
    if (contentType.endsWith("json")) {
      failedResult = JsonUtils.fromJson(new String(content), failedResultType);
    } else {
      contentConsumer.accept(content);
    }
  }

  /**
   * 返回下载是否是失败的结果
   *
   * @return 下载是否失败
   */
  public boolean isFailed() {
    return failedResult != null;
  }

  /**
   * 只在失败的情况下才有结果
   *
   * @return 失败的结果
   */
  public R getFailedResult() {
    return failedResult;
  }
}
