package dev.usbharu.commons.illust.parser.impl.jpeg.xmp;

import org.jetbrains.annotations.NotNull;

public interface XmpMetadata {

  @NotNull String getNamespace();

  @NotNull String getPath();

}
