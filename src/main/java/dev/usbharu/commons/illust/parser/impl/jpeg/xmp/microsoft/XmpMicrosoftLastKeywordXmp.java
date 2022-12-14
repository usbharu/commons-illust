package dev.usbharu.commons.illust.parser.impl.jpeg.xmp.microsoft;

import dev.usbharu.commons.illust.metadata.Tag;
import org.jetbrains.annotations.NotNull;

public class XmpMicrosoftLastKeywordXmp implements Tag {

  private final String tag;

  public XmpMicrosoftLastKeywordXmp(String tag) {
    this.tag = tag;
  }

  @Override
  public @NotNull String getValue() {
    return tag;
  }

  @Override
  public @NotNull String getStringValue() {
    return tag;
  }
}
