package dev.usbharu.commons.illust.parser.impl.other.multi;

import dev.usbharu.commons.illust.common.IllustSource;
import dev.usbharu.commons.illust.metadata.Illust;
import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.parser.IllustParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class MultiParser extends IllustParser {

  List<IllustParser> illustParsers;

  public MultiParser(IllustParser... illustParsers) {
    this.illustParsers.addAll(Arrays.asList(illustParsers));
  }

  @Override
  public @NotNull Illust parse(IllustSource illustSource) {
    List<Illust> illustList = new ArrayList<>();
    for (IllustParser illustParser : illustParsers) {
      illustList.add(illustParser.parse(illustSource));
    }
    return new MultiMetadataIllust(illustList);
  }
}
