package dev.usbharu.commons.illust.parser.impl.jpeg.exif;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.impl.jpeg.exif.value.XpTagExifValueParser;
import java.util.Collections;
import java.util.List;

public class DefaultExifValueParserFactory
    extends ExifValueParserFactory {

  @Override
  public ExifValueParser create(int tagId) {
    if (tagId == 0x9c9e) {
      return new XpTagExifValueParser();
    }
    return new ExifValueParser() {
      @Override
      public List<? extends MetadataValue> parse(byte[] value) {
        return Collections.emptyList();
      }
    };
  }
}
