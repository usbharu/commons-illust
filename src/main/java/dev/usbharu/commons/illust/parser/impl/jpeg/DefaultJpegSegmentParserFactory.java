package dev.usbharu.commons.illust.parser.impl.jpeg;

import dev.usbharu.commons.illust.common.ArrayUtil;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.impl.jpeg.exif.ExifParser;
import dev.usbharu.commons.illust.parser.impl.jpeg.xmp.XmpParser;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DefaultJpegSegmentParserFactory
    extends JpegSegmentParserFactory {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(DefaultJpegSegmentParserFactory.class);

  private static final byte[] exifIdentificationCode = "Exif".getBytes(StandardCharsets.UTF_8);
  private static final byte[] xmpIdentificationCode =
      "http://ns.adobe.com/xap/1.0/".getBytes(StandardCharsets.UTF_8);

  @Override
  public JpegSegmentParser create(byte[] segment) {
    if (ArrayUtil.equals(segment, 0, exifIdentificationCode.length, exifIdentificationCode, 0,
        exifIdentificationCode.length)) {
      LOGGER.debug("Exif Metadata");
      return new ExifParser();
    } else if (ArrayUtil.equals(segment, 0, xmpIdentificationCode.length, xmpIdentificationCode, 0,
        xmpIdentificationCode.length)) {
      LOGGER.debug("XMP Metadata");
      return new XmpParser();
    } else {
      LOGGER.debug("Other Metadata");
      return new JpegSegmentParser() {
        @Override
        public List<? extends MetadataValue> parse(byte[] segment) {
          return Collections.emptyList();
        }
      };
    }
  }
}
