package dev.usbharu.commons.illust.parser;

import static org.junit.jupiter.api.Assertions.*;

import dev.usbharu.commons.illust.common.IllustSource;
import org.junit.jupiter.api.Test;

abstract class IllustParserFactoryTest {

  protected IllustParserFactory illustParserFactory;

  protected IllustSource illustSource;

  @Test
  void from_IllustSource_returnIllustParser() {
    IllustParser illustParser = illustParserFactory.from(illustSource);
    assertNotNull(illustParser);
  }

  @Test
  void from_null_returnNull() {
    IllustParser illustParser = illustParserFactory.from(null);
    assertNull(illustParser);
  }
}
