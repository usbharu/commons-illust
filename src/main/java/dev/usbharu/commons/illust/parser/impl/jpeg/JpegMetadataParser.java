package dev.usbharu.commons.illust.parser.impl.jpeg;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.metadata.Tag;
import dev.usbharu.commons.illust.metadata.Title;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class JpegMetadataParser {

  private final InputStream inputStream;
  private final JpegMetadata jpegMetadata = new JpegMetadata();
  public static JpegSegmentParserFactory jpegSegmentParserFactory =
      new DefaultJpegSegmentParserFactory();

  private static final Logger LOGGER = LoggerFactory.getLogger(JpegMetadataParser.class);

  JpegMetadataParser(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  public JpegMetadata parse() throws IOException {
    try (InputStream is = inputStream) {
      int read = 0;
      is.read();
      while ((read = is.read()) != -1) {
        if (read != 0xff) {
          continue;
        }
        int read1 = is.read();
        if (read1 == 0xe1) {
          byte[] b = new byte[readSize(is) - 2];
          is.read(b);
          LOGGER.debug("Parse Data length :{}", b.length);
          parseMetadata(b);
        } else {
          is.skip(readSize(is) - 2);
        }
      }
    }
    return jpegMetadata;
  }

  // TODO: 2022/11/22 factory Methodパターンで作り直す
  protected void parseMetadata(byte[] appSegment) {
    JpegSegmentParser jpegSegmentParser = jpegSegmentParserFactory.create(appSegment);
    List<? extends MetadataValue> parse = jpegSegmentParser.parse(appSegment);
    for (MetadataValue metadataValue : parse) {
      if (metadataValue instanceof Tag) {
        jpegMetadata.tagList.add(((Tag) metadataValue));
      } else if (metadataValue instanceof Title) {
        jpegMetadata.titleList.add((Title) metadataValue);
      }
    }
  }

  private short readSize(InputStream is) throws IOException {
    short size = (short) (is.read() << 8 | is.read());
    LOGGER.debug("Size : {}", String.format("%X", size));
    return size;
  }

}
