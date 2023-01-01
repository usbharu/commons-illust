package dev.usbharu.commons.illust.parser.impl.jpeg;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class JpegMetadataParser {

  private final InputStream inputStream;
  public static JpegSegmentParserFactory jpegSegmentParserFactory =
      new DefaultJpegSegmentParserFactory();

  private static final Logger LOGGER = LoggerFactory.getLogger(JpegMetadataParser.class);

  JpegMetadataParser(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  public JpegMetadata parse() throws IOException {
    List<MetadataValue> metadataValues = new ArrayList<>();
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
          metadataValues.addAll(parseMetadata(b));
        } else {
          is.skip(readSize(is) - 2);
        }
      }
    }
    return new JpegMetadata(metadataValues);
  }

  // TODO: 2022/11/22 factory Methodパターンで作り直す
  protected List<? extends MetadataValue> parseMetadata(byte[] appSegment) {
    JpegSegmentParser jpegSegmentParser = jpegSegmentParserFactory.create(appSegment);
    return jpegSegmentParser.parse(appSegment);
  }

  private int readSize(InputStream is) throws IOException {
    int size = (is.read() << 8 | is.read());
    LOGGER.debug("Size : {}", String.format("%X", size));
    return size;
  }

}
