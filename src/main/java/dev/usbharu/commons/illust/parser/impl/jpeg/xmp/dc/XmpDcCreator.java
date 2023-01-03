package dev.usbharu.commons.illust.parser.impl.jpeg.xmp.dc;

import dev.usbharu.commons.illust.metadata.Artist;
import dev.usbharu.commons.illust.parser.impl.jpeg.xmp.AbstractXmpMetadata;
import org.jetbrains.annotations.NotNull;

public class XmpDcCreator extends AbstractXmpMetadata implements Artist {

  private final String artistName;

  public XmpDcCreator(String artistName, String namespace, String path) {
    super(namespace, path);
    this.artistName = artistName;
  }

  @Override
  public @NotNull String getValue() {
    return artistName;
  }

  @Override
  public @NotNull String getStringValue() {
    return artistName;
  }
}
