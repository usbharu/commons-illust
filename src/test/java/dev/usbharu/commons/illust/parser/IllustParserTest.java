package dev.usbharu.commons.illust.parser;

import static org.junit.jupiter.api.Assertions.*;

import dev.usbharu.commons.illust.common.IllustSource;
import dev.usbharu.commons.illust.metadata.Illust;

abstract class IllustParserTest {

  protected IllustParser illustParser;


  protected IllustSource illustSource;

  void parse_illustSource_returnIllust() {
    Illust illust = illustParser.parse(illustSource);
    assertNotNull(illust);

  }

  void parse_null_throwNullPointException() {
    assertThrows(NullPointerException.class, () -> illustParser.parse(null));
  }
}
