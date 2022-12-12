package dev.usbharu.commons.illust.parser.impl.other.pixiv;

import dev.usbharu.commons.illust.metadata.Title;
import org.jetbrains.annotations.NotNull;

public class PixivIllustTitle implements Title {

  private final String title;

  public PixivIllustTitle(String title) {
    this.title = title;
  }

  @Override
  public @NotNull String getValue() {
    return title;
  }

  @Override
  public @NotNull String getStringValue() {
    return title;
  }
}
