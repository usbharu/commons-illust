package dev.usbharu.commons.illust.metadata;

import dev.usbharu.commons.illust.metadata.type.Stringable;
import org.jetbrains.annotations.NotNull;

public interface Tag extends Stringable {

  @NotNull String getStringValue();

  @Override
  @NotNull String getValue();
}
