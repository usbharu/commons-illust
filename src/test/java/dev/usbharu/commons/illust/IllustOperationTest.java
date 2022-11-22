package dev.usbharu.commons.illust;

import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.metadata.Tag;
import dev.usbharu.commons.illust.metadata.Taggable;
import java.io.File;
import org.junit.jupiter.api.Test;

class IllustOperationTest {

  @Test
  void name() {
    Metadata metadata =
        IllustOperation.getIllust(new File("K:\\資料\\趣味\\イラスト\\4\\73730976_p0.jpg"))
            .getMetadata();
    System.out.println("metadata = " + metadata);
    if (metadata instanceof Taggable) {
      for (Tag tag : ((Taggable) metadata).getAllTag()) {
        System.out.println(tag.getString());
      }
    }
  }
}
