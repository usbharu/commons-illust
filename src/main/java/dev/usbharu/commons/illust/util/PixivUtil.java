package dev.usbharu.commons.illust.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PixivUtil {

  private static final String imageFileExtensionRegex = "(jpg|jpeg|JPG|JPEG|png|PNG)$";
  private final static Pattern isPixivIllust =
      Pattern.compile("^(\\d+)_p\\d+\\." + imageFileExtensionRegex);
  private final static Pattern pixivIllustId = isPixivIllust;
  private final static Pattern pixivIllustNumber =
      Pattern.compile("^\\d+_p(\\d+)\\." + imageFileExtensionRegex);


  public static boolean isPixivFileName(String name) {
    return isPixivIllust.matcher(name).find();
  }

  public static String getPixivIllustId(String name) {
    Matcher matcher = pixivIllustId.matcher(name);
    if (matcher.find()) {
      return matcher.group(1);
    }
    return "";
  }

  public static String getPixivIllustNumber(String name) {
    Matcher matcher = pixivIllustNumber.matcher(name);
    if (matcher.find()) {
      return matcher.group(1);
    }
    return "";
  }

}
