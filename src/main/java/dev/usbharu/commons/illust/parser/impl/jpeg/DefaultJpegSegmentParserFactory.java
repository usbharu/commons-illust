package dev.usbharu.commons.illust.parser.impl.jpeg;

import dev.usbharu.commons.illust.common.ArrayUtil;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.impl.jpeg.exif.ExifParser;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;


public class DefaultJpegSegmentParserFactory
    extends JpegSegmentParserFactory {

  private static final byte[] exifIdentificationCode = "Exif".getBytes(StandardCharsets.UTF_8);
  private static final byte[] xmpIdentificationCode =
      "http://ns.adobe.com/xap/1.0/".getBytes(StandardCharsets.UTF_8);

  @Override
  public JpegSegmentParser create(byte[] segment) {
    if (ArrayUtil.equals(segment, 0, exifIdentificationCode.length, exifIdentificationCode, 0,
        exifIdentificationCode.length)) {
      return new ExifParser();
    } else {
      return new JpegSegmentParser() {
        @Override
        public List<? extends MetadataValue> parse(byte[] segment) {
          return Collections.emptyList();
        }
      };
    }
  }
}
