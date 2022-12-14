package dev.usbharu.commons.illust.parser.impl.other.multi;

import dev.usbharu.commons.illust.metadata.Illust;
import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiMetadataIllust implements Illust {

  private final List<Illust> illustList;

  public MultiMetadataIllust(List<Illust> illustList) {
    this.illustList = illustList;
  }

  public MultiMetadataIllust(Illust... illustArray) {
    this.illustList = new ArrayList<>(Arrays.asList(illustArray));
  }


  @Override
  public Metadata getMetadata() {

    List<MetadataValue> metadataValues = new ArrayList<>();
    for (Illust illust : illustList) {
      metadataValues.addAll(illust.getMetadata().getAllMetadata());
    }
    return new MultiMetadata(metadataValues);
  }

  private static class MultiMetadata implements Metadata {

    private final List<? extends MetadataValue> metadataValues;

    private MultiMetadata(List<? extends MetadataValue> metadataValues) {
      this.metadataValues = metadataValues;
    }

    @Override
    public List<? extends MetadataValue> getAllMetadata() {
      return metadataValues;
    }
  }
}
