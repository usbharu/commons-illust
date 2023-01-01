package dev.usbharu.commons.illust.parser.impl.jpeg.xmp.dc;

import dev.usbharu.commons.illust.metadata.Tag;
import dev.usbharu.commons.illust.parser.impl.jpeg.xmp.AbstractXmpMetadata;
import org.jetbrains.annotations.NotNull;

public class XmpDcSubject extends AbstractXmpMetadata implements Tag {

  private final String tag;

  public XmpDcSubject(String tag, String namespace, String path) {
    super(namespace, path);
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
