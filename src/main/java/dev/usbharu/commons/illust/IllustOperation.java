package dev.usbharu.commons.illust;

import dev.usbharu.commons.illust.common.FileIllustSource;
import dev.usbharu.commons.illust.common.IllustSource;
import dev.usbharu.commons.illust.common.InputStreamIllustSource;
import dev.usbharu.commons.illust.metadata.Illust;
import dev.usbharu.commons.illust.parser.IllustParser;
import dev.usbharu.commons.illust.parser.IllustParserFactory;
import dev.usbharu.commons.illust.parser.impl.DefaultIllustParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;

public final class IllustOperation {

  private IllustOperation() {
    throw new IllegalStateException();
  }

  public static @NotNull Illust getIllust(@NotNull String path) {
    File file = new File(path);
    if (file.exists()) {
      return getIllust(file);
    }
    InputStream resourceAsStream = IllustOperation.class.getResourceAsStream(path);
    if (resourceAsStream != null) {
      InputStreamIllustSource inputStreamIllustSource =
          new InputStreamIllustSource(resourceAsStream, path);
      return getIllust(inputStreamIllustSource);
    }
    throw new IllegalArgumentException("ファイルが見つかりません. " + path);
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
