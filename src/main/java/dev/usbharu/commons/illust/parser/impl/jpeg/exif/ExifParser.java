package dev.usbharu.commons.illust.parser.impl.jpeg.exif;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.impl.jpeg.JpegSegmentParser;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExifParser extends JpegSegmentParser {

  public static final List<? extends MetadataValue> metadataList = new ArrayList<>();

  public ExifValueParserFactory exifValueParserFactory = new DefaultExifValueParserFactory();

  private static String hexToString(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte aByte : bytes) {
      sb.append(String.format("%02x", aByte));
    }
    return sb.toString();
  }

  public List<? extends MetadataValue> parse(byte[] segment) {
    ByteBuffer byteBuffer = ByteBuffer.wrap(segment);
    byteBuffer.get(6);
    if (segment[6] != (byte) 0x4d && segment[7] != (byte) 0x4d) {
      byteBuffer = byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }
    byteBuffer.position(10);
    int ifdOffset = byteBuffer.getInt();
    byteBuffer.position(ifdOffset + 6);
    short ifdCount = byteBuffer.getShort();

    List<MetadataValue> metadataValueList = new ArrayList<>();
    for (int i = 0; i < ifdCount; i++) {
      metadataValueList.addAll(readField(byteBuffer));
    }
    return metadataValueList;
  }

  protected List<? extends MetadataValue> readField(ByteBuffer byteBuffer) {
    int exifTag = byteBuffer.getShort() & 0xffff;
    short type = byteBuffer.getShort();
    IfdType ifdType = IfdType.typeOf(type);
    int count = byteBuffer.getInt();
    int valueLength = ifdType.length * count;

    if (byteBuffer.limit() < valueLength) {
      return Collections.emptyList();
    }

    byteBuffer.mark();
    if (valueLength > 4) {
      int offset = byteBuffer.getInt();
      byteBuffer.position(offset + 6); //todo: positionをここで動かすと、markが消える可能性がある。
    }

    ExifValueParser exifValueParser = getExifValueParser(exifTag);
    byte[] value = new byte[valueLength];
    byteBuffer.get(value);
    List<? extends MetadataValue> metadataValues = exifValueParser.parse(value);

    byteBuffer.reset();
    byteBuffer.getInt();
    return metadataValues;
  }

  protected ExifValueParser getExifValueParser(int tagId) {
    return exifValueParserFactory.create(tagId);
  }
}
