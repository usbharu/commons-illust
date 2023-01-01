package dev.usbharu.commons.illust.parser.impl.jpeg;

import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import java.util.Collections;
import java.util.List;

public class JpegMetadata implements Metadata {

  private final List<MetadataValue> metadataValues;

  public JpegMetadata(List<MetadataValue> metadataValues) {
    this.metadataValues = Collections.unmodifiableList(metadataValues);
  }

  public JpegMetadata() {
    metadataValues = Collections.emptyList();
  }

  @Override
  public List<? extends MetadataValue> getAllMetadata() {
    return metadataValues;
  }
}
