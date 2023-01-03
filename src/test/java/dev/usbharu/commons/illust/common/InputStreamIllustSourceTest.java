package dev.usbharu.commons.illust.common;

import dev.usbharu.TestUtils;
import org.junit.jupiter.api.BeforeEach;

public class InputStreamIllustSourceTest
    extends IllustSourceTest {

  @BeforeEach
  void setUp() {
    illustSource =
        new InputStreamIllustSource(TestUtils.getFileInputStream(InputStreamIllustSource.class,
            "illustsource/123456_p1.png"), "123456_p1.png");
  }
}
