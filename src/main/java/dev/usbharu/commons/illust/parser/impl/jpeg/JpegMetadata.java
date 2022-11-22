package dev.usbharu.commons.illust.parser.impl.jpeg;

import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.metadata.Tag;
import dev.usbharu.commons.illust.metadata.Taggable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JpegMetadata implements Metadata, Taggable {

  List<Tag> tagList = new ArrayList<>();

  public JpegMetadata(List<Tag> tagList) {
    this.tagList = tagList;
  }

  public JpegMetadata() {
  }

  @Override
  public List<Tag> getAllTag() {
    return Collections.unmodifiableList(tagList);
  }
}
