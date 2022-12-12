package dev.usbharu.commons.illust.parser.impl.jpeg.exif.value;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.metadata.Title;
import dev.usbharu.commons.illust.parser.impl.jpeg.exif.ExifValueParser;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class XpTitleExifValueParser extends ExifValueParser {

  @Override
  public List<? extends MetadataValue> parse(byte[] value) {
    String title = new String(value, 0, value.length - 2, StandardCharsets.UTF_16LE);
    return Collections.singletonList(new XpTitle(title));
  }

  public static class XpTitle implements Title {

    private final String value;

    public XpTitle(String value) {
      this.value = value;
    }

    @Override
    public @NotNull Object getValue() {
      return value;
    }

    @Override
    public @NotNull String getStringValue() {
      return value;
    }
  }
}
