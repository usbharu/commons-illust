package dev.usbharu.commons.illust.parser;

import dev.usbharu.commons.illust.common.IllustSource;
import dev.usbharu.commons.illust.metadata.Illust;
import org.jetbrains.annotations.NotNull;

public abstract class IllustParser {

  @NotNull
  public abstract Illust parse(IllustSource illustSource);
}
