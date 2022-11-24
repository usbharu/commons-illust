package dev.usbharu.commons.illust.parser.impl.other.pixiv;

import dev.usbharu.commons.illust.metadata.Id;
import dev.usbharu.commons.illust.metadata.type.Integerable;

public class PixivIllustId implements Id, Integerable {

  private final int id;

  public PixivIllustId(int id) {
    this.id = id;
  }

  @Override
  public Integer getValue() {
    return id;
  }

  @Override
  public String getStringValue() {
    return String.valueOf(id);
  }

  @Override
  public Integer getIntegerValue() {
    return id;
  }
}
