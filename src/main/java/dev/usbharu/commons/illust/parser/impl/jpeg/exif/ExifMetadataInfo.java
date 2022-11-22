package dev.usbharu.commons.illust.parser.impl.jpeg.exif;

public class ExifMetadataInfo {

  final int tagId;
  final String tagName;

  final IfdType ifdType;

  public ExifMetadataInfo(int tagId, IfdType ifdType, String tagName) {
    this.tagId = tagId;
    this.tagName = tagName;
    this.ifdType = ifdType;
  }
}
