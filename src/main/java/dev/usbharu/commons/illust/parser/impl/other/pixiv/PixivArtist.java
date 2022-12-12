package dev.usbharu.commons.illust.parser.impl.other.pixiv;

import dev.usbharu.commons.illust.metadata.Artist;
import dev.usbharu.commons.illust.metadata.type.Integerable;
import org.jetbrains.annotations.NotNull;

public class PixivArtist implements Artist, Integerable {

  private final String screenName;
  private final long id;

  public PixivArtist(String screenName, long id) {
    this.screenName = screenName;
    this.id = id;
  }

  @Override
  public @NotNull String getValue() {
    return screenName;
  }

  @Override
  public @NotNull Long getIntegerValue() {
    return id;
  }

  @Override
  public @NotNull String getStringValue() {
    return screenName;
  }

}
