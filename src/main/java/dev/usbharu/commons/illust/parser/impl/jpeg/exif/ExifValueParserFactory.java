package dev.usbharu.commons.illust.parser.impl.jpeg.exif;

public abstract class ExifValueParserFactory {

  public abstract ExifValueParser create(int tagId);

  public ExifValueParser create(ExifMetadataInfo exifMetadataInfo) {
    return create(exifMetadataInfo.tagId);
  }
}
