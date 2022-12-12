package dev.usbharu.commons.illust.metadata.type;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import org.jetbrains.annotations.NotNull;

public interface Integerable extends MetadataValue {

  @NotNull Number getIntegerValue();
}
