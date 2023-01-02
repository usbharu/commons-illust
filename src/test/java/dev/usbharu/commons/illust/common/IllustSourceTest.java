package dev.usbharu.commons.illust.common;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class IllustSourceTest {

  protected IllustSource illustSource;

  @Test
  void getInputStream_returnInputStream() throws IOException {
    InputStream inputStream = illustSource.getInputStream();
    assertNotNull(inputStream);
  }

  @Test
  void getFileName_returnFileName() {
    String fileName = illustSource.getFileName();
    assertNotNull(fileName);
    assertNotEquals(0, fileName.length());
  }
}
