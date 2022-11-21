package dev.usbharu.commons.illust.metadata;

import java.util.List;

public interface Taggable {

  List<? extends Tag> getAllTag();
}
