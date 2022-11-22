package dev.usbharu.commons.illust.parser.impl.jpeg.exif.value;

import dev.usbharu.commons.illust.metadata.Comments;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.impl.jpeg.exif.ExifValueParser;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class XpCommentExifValueParser extends ExifValueParser {

  @Override
  public List<? extends MetadataValue> parse(byte[] value) {
    String comments = new String(value, 0, value.length - 2, StandardCharsets.UTF_16LE);
    return Collections.singletonList(new XpComments(comments));
  }

  public static class XpComments implements Comments {

    private final String comments;

    public XpComments(String comments) {
      this.comments = comments;
    }

    @Override
    public String getStringValue() {
      return comments;
    }

    @Override
    public Object getValue() {
      return comments;
    }
  }
}
