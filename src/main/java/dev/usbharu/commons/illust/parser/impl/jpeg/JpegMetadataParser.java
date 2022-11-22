package dev.usbharu.commons.illust.parser.impl.jpeg;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.metadata.Tag;
import dev.usbharu.commons.illust.metadata.Title;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


class JpegMetadataParser {

  private final InputStream inputStream;
  private final JpegMetadata jpegMetadata = new JpegMetadata();
  private final boolean xmp = false;
  private final boolean exif = true;

  JpegSegmentParserFactory jpegSegmentParserFactory = new DefaultJpegSegmentParserFactory();

  JpegMetadataParser(InputStream inputStream) {
    this.inputStream = inputStream;
  }

  public JpegMetadata parse() throws IOException {
    try (InputStream is = inputStream) {
      int read = 0;
      while (!isLoaded() && (read = is.read()) != -1) {
        if (read != 0xff) {
          continue;
        }
        int read1 = is.read();
        short size = (short) (is.read() << 8 | is.read());
        if (read1 == 0xe1) {
          byte[] b = new byte[size - 1];
          is.read(b);
          parseMetadata(b);
        } else {
          is.skip(size);
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

  private boolean isLoaded() {
    return xmp && exif;
  }

}
