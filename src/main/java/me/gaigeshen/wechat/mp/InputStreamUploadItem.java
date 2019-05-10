package me.gaigeshen.wechat.mp;

import org.apache.commons.lang3.Validate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 输入流上传项目
 *
 * @author gaigeshen
 */
public class InputStreamUploadItem extends AbatractUploadItem {
  private final byte[] overrideContent;
  public InputStreamUploadItem(String filename, InputStream in) {
    super(filename, null);
    Validate.notBlank(filename, "filename is required");
    Validate.notNull(in, "input stream is required");
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    byte[] buffer =  new byte[2048];
    int len;
    try {
      while ((len = in.read(buffer)) > 0) {
        bout.write(buffer, 0, len);
      }
    } catch (IOException e) {
      throw new IllegalStateException("Could not read data content from input stream: " + in, e);
    }
    this.overrideContent = bout.toByteArray();
  }

  @Override
  public byte[] getContent() {
    return overrideContent;
  }
}
