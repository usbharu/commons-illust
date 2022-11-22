package dev.usbharu.commons.illust.parser.impl.jpeg.exif;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import java.util.List;

public abstract class ExifValueParser {

  public abstract List<? extends MetadataValue> parse(byte[] value);
}
