package dev.usbharu.commons.illust.parser.impl.jpeg;

public abstract class JpegSegmentParserFactory {

  public abstract JpegSegmentParser create(byte[] segment);
}
