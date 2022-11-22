package dev.usbharu.commons.illust.parser.impl.jpeg.exif.value;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.metadata.Tag;
import dev.usbharu.commons.illust.parser.impl.jpeg.exif.ExifValueParser;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class XpKeywordsExifValueParser
    extends ExifValueParser {

  @Override
  public List<? extends MetadataValue> parse(byte[] value) {
    String tags = new String(value, 0, value.length - 2, StandardCharsets.UTF_16LE);
    String[] tagArray = tags.split("[;, ]");
    ArrayList<XpKeywords> xpKeywords = new ArrayList<>();
    for (String tag : tagArray) {
      xpKeywords.add(new XpKeywords(tag));
    }
    return xpKeywords;
  }

  public static class XpKeywords implements Tag {

    private final String value;

    public XpKeywords(String value) {
      this.value = value;
    }

    @Override
    public String getStringValue() {
      return value;
    }

    @Override
    public String getValue() {
      return value;
    }
  }
}
