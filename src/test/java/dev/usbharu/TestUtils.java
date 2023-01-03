package dev.usbharu;

import java.io.File;
import java.io.InputStream;

public class TestUtils {

  private TestUtils() {
    throw new IllegalStateException();
  }

  public static File getFile(Class<?> clazz, String resourcePath) {
    return new File(clazz.getClassLoader().getResource(resourcePath).getFile());
  }

  public static InputStream getFileInputStream(Class<?> clazz, String resourcePath) {
    return clazz.getClassLoader().getResourceAsStream(resourcePath);
  }
}
