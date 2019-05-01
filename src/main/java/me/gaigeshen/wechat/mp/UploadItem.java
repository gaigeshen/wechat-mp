package me.gaigeshen.wechat.mp;

/**
 * 上传项目
 *
 * @author gaigeshen
 */
public class UploadItem {
  private String filename;
  private byte[] content;

  public UploadItem(String filename, byte[] content) {
    this.filename = filename;
    this.content = content;
  }

  public String getFilename() {
    return filename;
  }

  public byte[] getContent() {
    return content;
  }
}
