package dev.usbharu.commons.illust.common;

import dev.usbharu.TestUtils;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;

public class FileIllustSourceTest
    extends IllustSourceTest {

  @BeforeEach
  void setUp() throws IOException {
    illustSource = new FileIllustSource(
        TestUtils.getFile(FileIllustSource.class, "illustsource/123456_p1.png"));
  }
}
