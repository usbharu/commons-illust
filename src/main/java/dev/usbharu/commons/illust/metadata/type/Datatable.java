package dev.usbharu.commons.illust.metadata.type;

import java.time.ZonedDateTime;
import org.jetbrains.annotations.NotNull;

public interface Datatable extends Integerable, Stringable {

  @Override
  @NotNull
  default Long getIntegerValue() {
    return getDateValue().toEpochSecond();
  }

  @Override
  @NotNull
  default String getStringValue() {
    return getDateValue().toString();
  }

  @NotNull ZonedDateTime getDateValue();
}
