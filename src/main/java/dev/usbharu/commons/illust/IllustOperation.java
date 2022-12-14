package dev.usbharu.commons.illust;

import dev.usbharu.commons.illust.common.FileIllustSource;
import dev.usbharu.commons.illust.common.IllustSource;
import dev.usbharu.commons.illust.metadata.Illust;
import dev.usbharu.commons.illust.parser.IllustParser;
import dev.usbharu.commons.illust.parser.IllustParserFactory;
import dev.usbharu.commons.illust.parser.impl.DefaultIllustParserFactory;
import java.io.File;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public final class IllustOperation {

  private IllustOperation() {
    throw new IllegalStateException();
  }

  public static @NotNull Illust getIllust(@NotNull File file) {
    try {
      return getIllust(new FileIllustSource(file));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static @NotNull Illust getIllust(IllustSource illustSource) {
    IllustParser illustParser = getIllustParser(illustSource);
    return illustParser.parse(illustSource);
  }

  private static IllustParser getIllustParser(IllustSource illustSource) {
    IllustParserFactory factory = new DefaultIllustParserFactory();

    return factory.from(illustSource);
  }

}
