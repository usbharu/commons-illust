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
            new File("K:\\資料\\趣味\\イラスト\\1\\___hnkn___ki-1517628060119580675-img1.jpg")), 1000,
        1000);
  }
}
