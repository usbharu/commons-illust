package dev.usbharu.commons.illust.parser.impl.jpeg.xmp;

import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.properties.XMPPropertyInfo;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.impl.jpeg.xmp.dc.DcXmpPropertyParser;
import dev.usbharu.commons.illust.parser.impl.jpeg.xmp.microsoft.MicrosoftXmpPropertyParser;
import java.util.Collections;
import java.util.List;

public class DefaultXmpPropertyParserFactory extends XmpPropertyParserFactory {

  private final XmpPropertyParser xmpPropertyParser = new XmpPropertyParser() {
    @Override
    public List<? extends MetadataValue> parse(XMPMeta meta, XMPPropertyInfo info) {
      return Collections.emptyList();
    }
  };

  @Override
  public XmpPropertyParser create(String nameSpace) {
    if (nameSpace == null || nameSpace.isEmpty()) {
      return xmpPropertyParser;
    }
    if (nameSpace.equals("http://purl.org/dc/elements/1.1/")) {
      return new DcXmpPropertyParser();
    } else if (nameSpace.equals("http://ns.microsoft.com/photo/1.0/")) {
      return new MicrosoftXmpPropertyParser();
    }
    return xmpPropertyParser;
  }
}
