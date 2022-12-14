import dev.usbharu.commons.illust.IllustOperation;
import dev.usbharu.commons.illust.metadata.Illust;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import java.io.File;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  void name() {
    Illust illust = IllustOperation.getIllust(
        new File(getClass().getResource("123456_p1.png").getFile()));
    List<? extends MetadataValue> allMetadata = illust.getMetadata().getAllMetadata();
    for (MetadataValue allMetadatum : allMetadata) {
      System.out.println(allMetadatum.getValue());
    }
  }
}
