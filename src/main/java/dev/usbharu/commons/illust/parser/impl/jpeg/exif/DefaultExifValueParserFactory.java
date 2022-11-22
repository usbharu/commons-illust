package dev.usbharu.commons.illust.parser.impl.jpeg.exif;

import dev.usbharu.commons.illust.metadata.MetadataValue;
import dev.usbharu.commons.illust.parser.impl.jpeg.exif.value.XpCommentExifValueParser;
import dev.usbharu.commons.illust.parser.impl.jpeg.exif.value.XpKeywordsExifValueParser;
import dev.usbharu.commons.illust.parser.impl.jpeg.exif.value.XpTitleExifValueParser;
import java.util.Collections;
import java.util.List;

public class DefaultExifValueParserFactory
    extends ExifValueParserFactory {

  @Override
  public ExifValueParser create(int tagId) {

    // TODO: 2022/11/22 ExifMetadataInfo 使うようにする
    if (tagId == ExifMetadataConstants.XP_KEYWORDS.tagId) {
      return new XpKeywordsExifValueParser();
    } else if (tagId == ExifMetadataConstants.XP_TITLE.tagId) {
      return new XpTitleExifValueParser();
    } else if (tagId == ExifMetadataConstants.XP_COMMENT.tagId) {
      return new XpCommentExifValueParser();
    }
    return new ExifValueParser() {
      @Override
      public List<? extends MetadataValue> parse(byte[] value) {
        return Collections.emptyList();
      }
    };
  }
}
