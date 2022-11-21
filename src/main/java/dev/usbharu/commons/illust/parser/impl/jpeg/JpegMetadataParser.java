package dev.usbharu.commons.illust.parser.impl.jpeg;

import dev.usbharu.commons.illust.common.ArrayUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


class JpegMetadataParser {

  private static final byte[] exifIdentificationCode = "Exif".getBytes(StandardCharsets.UTF_8);
  private static final byte[] xmpIdentificationCode =
      "http://ns.adobe.com/xap/1.0/".getBytes(StandardCharsets.UTF_8);
  private final InputStream inputStream;
  private final JpegMetadata jpegMetadata = new JpegMetadata();
  private boolean xmp = false;
  private boolean exif = true;

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
          // TODO: 2022/11/21 read metadata
        } else {
          is.skip(size);
        }
      }
    }
    return jpegMetadata;
  }

  protected void switchMetadata(byte[] appSegment) {
    if (ArrayUtil.equals(exifIdentificationCode, 0, 4, appSegment, 0, 4)) {
      parseExif(appSegment);
      exif = true;
    } else if (ArrayUtil.equals(xmpIdentificationCode, 0, 4, appSegment, 0, 4)) {
      parseXmp(appSegment);
      xmp = true;
    }
  }

  protected void parseXmp(byte[] segment) {

  }

  protected void parseExif(byte[] segment) {

  }

  private boolean isLoaded() {
    return xmp && exif;
  }
}
