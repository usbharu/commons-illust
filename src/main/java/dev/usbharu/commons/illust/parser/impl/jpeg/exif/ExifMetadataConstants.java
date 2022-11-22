package dev.usbharu.commons.illust.parser.impl.jpeg.exif;

public class ExifMetadataConstants {

  public static final ExifMetadataInfo XP_TITLE =
      new ExifMetadataInfo(0x9c9b, IfdType.BYTE, "XPTitle");
  public static final ExifMetadataInfo XP_COMMENT =
      new ExifMetadataInfo(0x9c9c, IfdType.BYTE, "XPComment");
  public static final ExifMetadataInfo XP_AUTHOR =
      new ExifMetadataInfo(0x9c9d, IfdType.BYTE, "XPAuthor");
  public static final ExifMetadataInfo XP_KEYWORDS =
      new ExifMetadataInfo(0x9c9e, IfdType.BYTE, "XPKeywords");
  public static final ExifMetadataInfo
      XP_SUBJECT = new ExifMetadataInfo(0x9c9f, IfdType.BYTE, "XPSubject");

  private ExifMetadataConstants() {
    throw new IllegalStateException();
  }

}
