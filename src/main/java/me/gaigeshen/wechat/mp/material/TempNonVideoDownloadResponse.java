package me.gaigeshen.wechat.mp.material;

import lombok.Getter;
import me.gaigeshen.wechat.mp.AbstractResponse;

/**
 * 临时非视频素材获取结果，成功的结果只会返回文件，失败的情况才会用到此类型，以便查看具体的错误信息。注意使用下载文件请求结果处理器。
 *
 * @author gaigeshen
 */
@Getter
public class TempNonVideoDownloadResponse extends AbstractResponse {
}
