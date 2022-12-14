package dev.usbharu.commons.illust.parser.impl.jpeg.xmp.dc;

import dev.usbharu.commons.illust.metadata.Artist;
import org.jetbrains.annotations.NotNull;

public class XmpDcCreator implements Artist {

  private final String artistName;

  public XmpDcCreator(String artistName) {
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
