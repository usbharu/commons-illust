package dev.usbharu.commons.illust.parser.impl.jpeg.xmp.dc;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.metadata.type.Stringable;
import dev.usbharu.commons.illust.parser.impl.jpeg.xmp.AbstractXmpMetadata;
import org.jetbrains.annotations.NotNull;

public class XmpDcFormat extends AbstractXmpMetadata implements MetadataValue, Stringable {

  private final String type;

  public XmpDcFormat(String type, String namespace, String path) {
    super(namespace, path);
    this.type = type;
  }

  @Override
  public @NotNull String getValue() {
    return type;
  }

  @Override
  public @NotNull String getStringValue() {
    return type;
  }
}
