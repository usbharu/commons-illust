package dev.usbharu.commons.illust.parser.impl.jpeg.xmp.microsoft;

import com.adobe.internal.xmp.XMPException;
import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.properties.XMPPropertyInfo;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.impl.jpeg.xmp.XmpPropertyParser;
import dev.usbharu.commons.illust.parser.impl.jpeg.xmp.XmpUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MicrosoftXmpPropertyParser extends XmpPropertyParser {

  @Override
  public List<? extends MetadataValue> parse(XMPMeta meta, XMPPropertyInfo info) {
    if (info.getPath() == null) {
      return Collections.emptyList();
    }
    if (info.getPath().equals("MicrosoftPhoto:LastKeywordXMP")) {
      try {
        return keyword(meta, info);
      } catch (XMPException e) {
        e.printStackTrace();
      }
    }
    return Collections.emptyList();
  }

  private List<MetadataValue> keyword(XMPMeta meta, XMPPropertyInfo info)
      throws XMPException {
    int count = XmpUtil.computeArraySize(meta, info);
    List<MetadataValue> result = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      result.add(
          new XmpMicrosoftLastKeywordXmp(XmpUtil.getFixedArrayItem(meta, info, i).getValue(),
              info.getNamespace(), info.getPath()));
    }
    return result;
  }
}
