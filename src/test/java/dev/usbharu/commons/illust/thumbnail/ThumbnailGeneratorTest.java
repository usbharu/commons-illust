package dev.usbharu.commons.illust.thumbnail;

import static org.junit.jupiter.api.Assertions.*;

import dev.usbharu.commons.illust.IllustOperation;
import dev.usbharu.commons.illust.common.FileIllustSource;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ThumbnailGeneratorTest {

  @Test
  void generate() throws IOException {
    ThumbnailGenerator thumbnailGenerator = new ThumbnailGenerator();
    thumbnailGenerator.generate(new FileIllustSource(
            new File(thumbnailGenerator.getClass().getClassLoader().getResource("thumbnail/waifu20.jpg")
                .getFile())), 300,
        300);
  }
}
