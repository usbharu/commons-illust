package dev.usbharu.commons.illust.parser.impl.other.pixiv;

import dev.usbharu.commons.illust.metadata.Tag;
import dev.usbharu.commons.illust.metadata.type.Stringable;
import org.jetbrains.annotations.NotNull;

public class PixivIllustTag implements Tag, Stringable {

  private final String tag;

  public PixivIllustTag(String tag) {
    this.tag = tag;
  }

  @Override
  public @NotNull String getValue() {
    return tag;
  }

  @Override
  public @NotNull String getStringValue() {
    return tag;
  }
}
