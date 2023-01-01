package dev.usbharu.commons.illust.parser.impl.jpeg.xmp.dc;

import com.adobe.internal.xmp.XMPException;
import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.properties.XMPPropertyInfo;
import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.impl.jpeg.xmp.XmpPropertyParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DcXmpPropertyParser extends XmpPropertyParser {

  @Override
  public List<? extends MetadataValue> parse(XMPMeta meta, XMPPropertyInfo info) {
    if (info.getPath() == null || info.getPath().isEmpty() || info.getPath().equals(" null")) {
      return Collections.emptyList();
    }
    DcTags dcTags;
    try {
      dcTags = DcTags.typeOf(info.getPath());
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      return Collections.emptyList();
    }
    try {

      switch (dcTags) {

        case CREATOR:
          return creator(meta, info);
        case FORMAT:
          return format(meta, info);
        case SUBJECT:
          return subject(meta, info);
        default:
          throw new IllegalStateException("Unexpected value: " + dcTags);
      }
    } catch (XMPException e) {
      e.printStackTrace();
      return Collections.emptyList();
    }
  }

  private List<MetadataValue> format(XMPMeta meta, XMPPropertyInfo info)
      throws XMPException {
    int count = meta.countArrayItems(info.getNamespace(), info.getPath());
    List<MetadataValue> result = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      result.add(
          new XmpDcFormat(meta.getArrayItem(info.getNamespace(), info.getPath(), i).getValue(),
              info.getNamespace(), info.getPath()));
    }
    return result;
  }

  private List<MetadataValue> subject(XMPMeta meta, XMPPropertyInfo info)
      throws XMPException {
    int count = meta.countArrayItems(info.getNamespace(), info.getPath());
    List<MetadataValue> result = new ArrayList<>();
    for (int i = 1; i <= count; i++) {
      result.add(
          new XmpDcSubject(meta.getArrayItem(info.getNamespace(), info.getPath(), i).getValue(),
              info.getNamespace(), info.getPath()));
    }
    return result;
  }

  //TODO : isArrayでチェック
  private List<MetadataValue> creator(XMPMeta meta, XMPPropertyInfo info)
      throws XMPException {
    int count = meta.countArrayItems(info.getNamespace(), info.getPath());
    List<MetadataValue> result = new ArrayList<>();
    for (int i = 1; i <= count; i++) {
      result.add(
          new XmpDcCreator(meta.getArrayItem(info.getNamespace(),
              info.getPath(),
              i).getValue(),
              info.getNamespace(),
              info.getPath()));
    }
    return result;
  }

  enum DcTags {
    CREATOR("dc:creator"), FORMAT("dc:format"), SUBJECT("dc:subject");
    private final String name;

    DcTags(String name) {
      this.name = name;
    }

    public static DcTags typeOf(String name) {
      for (DcTags value : values()) {
        if (value.name.equals(name)) {
          return value;
        }
      }
      throw new IllegalArgumentException("Not found : " + name);
    }
  }
}
