package dev.usbharu.commons.illust.common;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamIllustSource extends IllustSource {

  private final InputStream inputStream;

  public InputStreamIllustSource(InputStream inputStream, String fileName) {
    super(fileName);
    this.inputStream = inputStream;
  }

  @Override
  public InputStream getInputStream() throws IOException {
    return inputStream;
  }
}
