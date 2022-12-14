package dev.usbharu.commons.illust.parser.impl.jpeg.xmp;

import com.adobe.internal.xmp.XMPException;
import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.options.PropertyOptions;
import com.adobe.internal.xmp.properties.XMPProperty;
import com.adobe.internal.xmp.properties.XMPPropertyInfo;

public class XmpUtil {

  private XmpUtil() {
    throw new IllegalStateException();
  }

  public static int computeArraySize(XMPMeta meta, XMPPropertyInfo property) throws XMPException {
    return meta.countArrayItems(property.getNamespace(), property.getPath());
  }

  public static XMPProperty getFixedArrayItem(XMPMeta meta, XMPPropertyInfo propertyInfo, int index)
      throws XMPException {
    return meta.getArrayItem(propertyInfo.getNamespace(), propertyInfo.getPath(), index + 1);
  }
}
