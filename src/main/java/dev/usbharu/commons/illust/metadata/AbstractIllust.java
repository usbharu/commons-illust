package dev.usbharu.commons.illust.metadata;

public class AbstractIllust implements Illust {

  private final Metadata metadata;

  public AbstractIllust(Metadata metadata) {
    this.metadata = metadata;
  }

  @Override
  public Metadata getMetadata() {
    return metadata;
  }
}
