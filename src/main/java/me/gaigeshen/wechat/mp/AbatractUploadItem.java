package me.gaigeshen.wechat.mp;

/**
 * 抽象上传项目
 *
 * @author gaigeshen
 */
public abstract class AbatractUploadItem implements UploadItem {
  private String filename;
  private byte[] content;

  public AbatractUploadItem(String filename, byte[] content) {
    this.filename = filename;
    this.content = content;
  }

  @Override
  public String getFilename() {
    return filename;
  }
  @Override
  public byte[] getContent() {
    return content;
  }
}