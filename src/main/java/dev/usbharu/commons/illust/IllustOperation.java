package dev.usbharu.commons.illust;

import dev.usbharu.commons.illust.common.FileIllustSource;
import dev.usbharu.commons.illust.common.IllustSource;
import dev.usbharu.commons.illust.common.InputStreamIllustSource;
import dev.usbharu.commons.illust.metadata.Illust;
import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.IllustParser;
import dev.usbharu.commons.illust.parser.IllustParserFactory;
import dev.usbharu.commons.illust.parser.impl.DefaultIllustParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class IllustOperation {

  public static IllustParserFactory illustParserFactory = new DefaultIllustParserFactory();

  private static final Logger LOGGER = LoggerFactory.getLogger(IllustOperation.class);

  private IllustOperation() {
    throw new IllegalStateException();
  }

  public static @NotNull Illust getIllust(@NotNull String path) {
    File file = new File(path);
    if (file.exists()) {
      return getIllust(file);
    }
    URL resource = IllustOperation.class.getClassLoader().getResource(path);
    if (resource != null) {
      return getIllust(new File(resource.getFile()));
    }

    InputStream resourceAsStream = IllustOperation.class.getClassLoader().getResourceAsStream(path);
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
    } catch (NoSuchFileException e) {
      throw new IllegalArgumentException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static @NotNull Illust getIllust(IllustSource illustSource) {
    IllustParser illustParser = getIllustParser(illustSource);
    return illustParser.parse(illustSource);
  }

  public static <T extends MetadataValue> List<? extends MetadataValue> getMetadataByType(
      Metadata metadata, Class<T> type) {
    return metadata.getAllMetadata().stream()
        .filter(type::isInstance).collect(
            Collectors.toList());
  }

  public static <T extends MetadataValue> List<? extends MetadataValue> getMetadataByType(
      Illust illust, Class<T> type) {
    return getMetadataByType(illust.getMetadata(), type);
  }

  private static IllustParser getIllustParser(IllustSource illustSource) {
    IllustParserFactory factory = illustParserFactory;
    LOGGER.debug("Use factory {}", factory.getClass().getName());
    IllustParser illustParser = factory.from(illustSource);
    LOGGER.debug("Use parser {}", illustParser.getClass().getName());
    return illustParser;
  }

}
