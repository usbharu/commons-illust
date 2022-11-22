package dev.usbharu.commons.illust;

import dev.usbharu.commons.illust.metadata.Metadata;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.metadata.type.Stringable;
import java.io.File;
import org.junit.jupiter.api.Test;

class IllustOperationTest {

  @Test
  void name() {
    Metadata metadata =
        IllustOperation.getIllust(new File("K:\\資料\\趣味\\イラスト\\4\\73730976_p0.jpg"))
            .getMetadata();
    for (MetadataValue data : metadata.getAllMetadata()) {
      if (data instanceof Stringable) {
        System.out.println(((Stringable) data).getStringValue());
      }
    }
  }
}
