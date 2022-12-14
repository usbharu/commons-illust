package dev.usbharu.commons.illust.parser.impl;

import dev.usbharu.commons.illust.common.IllustSource;
import dev.usbharu.commons.illust.parser.IllustParser;
import dev.usbharu.commons.illust.parser.IllustParserFactory;
import dev.usbharu.commons.illust.parser.impl.jpeg.JpegIllustParser;
import dev.usbharu.commons.illust.parser.impl.jpeg.xmp.XmpParser;
import dev.usbharu.commons.illust.parser.impl.other.pixiv.PowerfulPixivDownloaderMetafileParser;

public class DefaultIllustParserFactory extends IllustParserFactory {

  @Override
  public IllustParser from(IllustSource illustSource) {
    return new JpegIllustParser();
  }
}
