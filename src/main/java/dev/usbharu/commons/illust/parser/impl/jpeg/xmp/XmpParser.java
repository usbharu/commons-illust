package dev.usbharu.commons.illust.parser.impl.jpeg.xmp;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.impl.jpeg.JpegSegmentParser;
import java.util.Collections;
import java.util.List;

public class XmpParser extends JpegSegmentParser {

  @Override
  public List<? extends MetadataValue> parse(byte[] segment) {
    String xmpXmlStr = new String(segment);

    return Collections.emptyList();
  }
}
