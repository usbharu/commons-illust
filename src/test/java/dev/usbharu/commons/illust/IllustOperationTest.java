package dev.usbharu.commons.illust;

import static org.junit.jupiter.api.Assertions.*;

import dev.usbharu.commons.illust.metadata.Illust;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.metadata.Tag;
import java.io.File;
import java.net.URL;
import java.util.List;
import org.junit.jupiter.api.Test;

class IllustOperationTest {

  @Test
  void getIllust_jpegFile_returnJpegIllust() {

    File file =
        new File(IllustOperation.class.getClassLoader().getResource("Konako.jpg").getFile());
    Illust illust = IllustOperation.getIllust(file);
    List<? extends MetadataValue> allMetadata = illust.getMetadata().getAllMetadata();
    for (MetadataValue allMetadatum : allMetadata) {
      System.out.println("allMetadatum.getValue() = " + allMetadatum.getValue());
    }
    assertEquals(6, allMetadata.size());
  }

  @Test
  void getIllust_pixivIllust_returnPixivIllust() {
    File file =
        new File(IllustOperation.class.getClassLoader().getResource("123456_p1.png").getFile());
    Illust illust = IllustOperation.getIllust(file);
    assertEquals(11, illust.getMetadata().getAllMetadata().size());
  }

  @Test
  void getIllust_pixivAndJpegIllust_returnMultiIllust() {
    File file =
        new File(IllustOperation.class.getClassLoader().getResource("987654321_p1.jpg").getFile());
    Illust illust = IllustOperation.getIllust(file);
    List<? extends MetadataValue> allMetadata = illust.getMetadata().getAllMetadata();
    for (MetadataValue allMetadatum : allMetadata) {
      System.out.println(allMetadatum.getValue());
    }
    assertEquals(13, allMetadata.size());
  }
}
