package dev.usbharu.commons.illust.parser.impl.jpeg;

import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.metadata.Tag;
import dev.usbharu.commons.illust.metadata.Taggable;
import java.util.Collections;
import java.util.List;

public class JpegMetadata implements Metadata, Taggable {

  List<? extends Tag> tagList;

  public JpegMetadata(List<? extends Tag> tagList) {
    this.tagList = tagList;
  }

  public JpegMetadata() {
    this.tagList = Collections.emptyList();
  }

  @Override
  public List<? extends Tag> getAllTag() {
    return Collections.unmodifiableList(tagList);
  }
}
