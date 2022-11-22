package dev.usbharu.commons.illust.metadata;

import java.util.List;

public interface Metadata {

  List<? extends MetadataValue> getAllMetadata();
}
