package me.gaigeshen.wechat.mp;

/**
 * 上传项目
 *
 * @author gaigeshen
 */
public interface UploadItem {
  String getFilename();
  byte[] getContent();
}
