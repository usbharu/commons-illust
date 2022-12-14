package dev.usbharu.commons.illust.common;

import java.io.IOException;
import java.io.InputStream;

public abstract class IllustSource {

  private final String fileName;

  public IllustSource(String fileName) {

    this.fileName = fileName;
  }

  public abstract InputStream getInputStream() throws IOException;

  public String getFileName() {
    return fileName;
  }
}
