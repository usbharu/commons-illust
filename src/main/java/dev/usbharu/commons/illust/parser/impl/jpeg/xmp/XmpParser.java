package dev.usbharu.commons.illust.parser.impl.jpeg.xmp;

import com.adobe.internal.xmp.XMPException;
import com.adobe.internal.xmp.XMPIterator;
import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.XMPMetaFactory;
import com.adobe.internal.xmp.properties.XMPPropertyInfo;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.impl.jpeg.JpegSegmentParser;
import java.util.Collections;
import java.util.List;

public class XmpParser extends JpegSegmentParser {

  public static XmpPropertyParserFactory xmpPropertyParserFactory =
      new DefaultXmpPropertyParserFactory();

  @Override
  public List<? extends MetadataValue> parse(byte[] segment) {
    try {
      XMPMeta xmpMeta = XMPMetaFactory.parseFromBuffer(segment);
      XMPIterator iterator = xmpMeta.iterator();
      while (iterator.hasNext()) {
        XMPPropertyInfo xmpPropertyInfo = (XMPPropertyInfo) iterator.next();
        XmpPropertyParser xmpPropertyParser =
            xmpPropertyParserFactory.create(xmpPropertyInfo.getNamespace());
        xmpPropertyParser.parse(xmpMeta, xmpPropertyInfo);

      }
    } catch (XMPException e) {
      throw new RuntimeException(e);
    }
    return Collections.emptyList();
  }
}
