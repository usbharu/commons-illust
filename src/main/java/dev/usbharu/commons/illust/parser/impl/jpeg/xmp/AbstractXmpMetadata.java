package dev.usbharu.commons.illust.parser.impl.jpeg.xmp;

import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.properties.XMPPropertyInfo;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractXmpMetadata
    implements XmpMetadata {

  private final String namespace;
  private final String path;

  public AbstractXmpMetadata(String namespace, String path) {
    this.namespace = namespace;
    this.path = path;
  }

  public AbstractXmpMetadata(XMPPropertyInfo xmpInfo) {
    namespace = xmpInfo.getNamespace();
    path = xmpInfo.getPath();
  }

  @Override
  public @NotNull String getNamespace() {
    return namespace;
  }

  @Override
  public @NotNull String getPath() {
    return path;
  }
}
