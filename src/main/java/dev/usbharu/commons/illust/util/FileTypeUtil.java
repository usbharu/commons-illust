package dev.usbharu.commons.illust.util;

import java.util.regex.Pattern;

public class FileTypeUtil {

  private FileTypeUtil() {
    throw new IllegalStateException();
  }

  public static final Pattern isJpeg = Pattern.compile("\\.(jpeg|jpg|JPEG|JPG)"
      + "$");

  public static boolean isJpeg(String name) {
    return isJpeg.matcher(name).find();
  }

}
