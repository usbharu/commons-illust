package dev.usbharu.commons.illust;

import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.metadata.Tag;
import dev.usbharu.commons.illust.metadata.Taggable;
import dev.usbharu.commons.illust.metadata.type.Stringable;
import java.io.File;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class IllustOperationTest {

  @Test
  void name() {
    Logger logger = LoggerFactory.getLogger(IllustOperationTest.class);
    logger.info("aaaaaaaaaaaa");
    Metadata metadata =
        IllustOperation.getIllust(new File("K:\\資料\\趣味\\イラスト\\4\\73730976_p0.jpg"))
            .getMetadata();
    for (MetadataValue data : metadata.getAllMetadata()) {
      if (data instanceof Stringable) {
        System.out.println(((Stringable) data).getStringValue());
      }
    }
  }

  @Test
  void aaa() {
    for (int i = 0; i < 3; i++) {
      long l = System.currentTimeMillis();
      for (File file : new File("K:\\資料\\趣味\\クッキークリッカー\\しょぼいマフィンベーカリー").listFiles(
          (dir, name) -> name.endsWith(".jpg"))) {
        Metadata metadata = IllustOperation.getIllust(file).getMetadata();
        if (metadata instanceof Taggable) {
          List<? extends Tag> allTag = ((Taggable) metadata).getAllTag();
        }
      }
      long l2 = System.currentTimeMillis();
      System.out.println(l2 - l);
    }
  }
}
