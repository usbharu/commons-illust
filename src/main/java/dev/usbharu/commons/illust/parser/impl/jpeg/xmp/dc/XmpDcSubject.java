package dev.usbharu.commons.illust.parser.impl.jpeg.xmp.dc;

import dev.usbharu.commons.illust.metadata.Tag;
import org.jetbrains.annotations.NotNull;

public class XmpDcSubject implements Tag {

  private final String tag;

  public XmpDcSubject(String tag) {
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
