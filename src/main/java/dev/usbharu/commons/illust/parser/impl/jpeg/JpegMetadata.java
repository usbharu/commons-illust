package dev.usbharu.commons.illust.parser.impl.jpeg;

import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.metadata.Tag;
import dev.usbharu.commons.illust.metadata.Taggable;
import dev.usbharu.commons.illust.metadata.Title;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JpegMetadata implements Metadata, Taggable {

  List<Tag> tagList = new ArrayList<>();

  List<Title> titleList = new ArrayList<>();

  public JpegMetadata(List<Tag> tagList) {
    this.tagList = tagList;
  }

  public JpegMetadata() {
  }

  @Override
  public List<Tag> getAllTag() {
    return Collections.unmodifiableList(tagList);
  }

  @Override
  public List<? extends MetadataValue> getAllMetadata() {
    List<MetadataValue> metadataValues = new ArrayList<>(tagList);
    metadataValues.addAll(titleList);
    return metadataValues;
  }
}
