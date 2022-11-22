package dev.usbharu.commons.illust.parser.impl.jpeg;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import java.util.List;

public abstract class JpegSegmentParser {

  public abstract List<? extends MetadataValue> parse(byte[] segment);
}
