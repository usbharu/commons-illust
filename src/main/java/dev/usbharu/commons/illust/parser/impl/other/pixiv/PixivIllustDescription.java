package dev.usbharu.commons.illust.parser.impl.other.pixiv;

import dev.usbharu.commons.illust.metadata.Description;
import org.jetbrains.annotations.NotNull;

public class PixivIllustDescription implements Description {

  private final String description;

  public PixivIllustDescription(String description) {
    this.description = description;
  }

  @Override
  public @NotNull String getValue() {
    return description;
  }

  @Override
  public @NotNull String getStringValue() {
    return description;
  }
}
