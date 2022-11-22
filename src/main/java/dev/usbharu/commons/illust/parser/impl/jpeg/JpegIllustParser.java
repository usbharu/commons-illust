package dev.usbharu.commons.illust.parser.impl.jpeg;

import dev.usbharu.commons.illust.common.IllustSource;
import dev.usbharu.commons.illust.metadata.AbstractIllust;
import dev.usbharu.commons.illust.metadata.Illust;
import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.parser.IllustParser;
import java.io.IOException;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;

public class JpegIllustParser extends IllustParser {

  @Override
  public @NotNull Illust parse(IllustSource illustSource) {
    return new AbstractIllust(parseMetadata(illustSource));
  }

  private Metadata parseMetadata(IllustSource illustSource) {
    try (InputStream inputStream = illustSource.getInputStream()) {
      JpegMetadataParser jpegMetadataParser = new JpegMetadataParser(inputStream);
      return jpegMetadataParser.parse();
    } catch (IOException e) {
    }
    throw new IllegalStateException();
  }
}
