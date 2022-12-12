package dev.usbharu.commons.illust.metadata.type;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import org.jetbrains.annotations.NotNull;

public interface Stringable extends MetadataValue {

  @NotNull String getStringValue();
}
