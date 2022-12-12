package dev.usbharu.commons.illust.parser.impl.other.pixiv;

import dev.usbharu.commons.illust.metadata.Id;
import dev.usbharu.commons.illust.metadata.type.Integerable;
import org.jetbrains.annotations.NotNull;

public class PixivIllustId implements Id, Integerable {

  private final int id;

  public PixivIllustId(int id) {
    this.id = id;
  }

  @Override
  public @NotNull Integer getValue() {
    return id;
  }

  @Override
  public @NotNull String getStringValue() {
    return String.valueOf(id);
  }

  @Override
  public @NotNull Integer getIntegerValue() {
    return id;
  }
}
